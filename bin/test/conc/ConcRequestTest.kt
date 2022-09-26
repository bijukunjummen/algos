package conc

import org.junit.jupiter.api.Test
import java.time.Instant

data class WebRequest(
        val start: Instant,
        val end: Instant
)

data class WebRequestFlattened(
        val time: Instant,
        val state: String
)


class TestConcRequests {

    @Test
    fun testConcRequests() {
        val day = "2019-01-01"
        val reqs = listOf(
                WebRequest(Instant.parse("${day}T01:00:00Z"), Instant.parse("${day}T01:10:00Z")),
                WebRequest(Instant.parse("${day}T01:05:00Z"), Instant.parse("${day}T01:15:00Z")),
                WebRequest(Instant.parse("${day}T01:10:00Z"), Instant.parse("${day}T01:20:00Z")),
                WebRequest(Instant.parse("${day}T01:15:00Z"), Instant.parse("${day}T01:20:00Z")),
                WebRequest(Instant.parse("${day}T01:17:00Z"), Instant.parse("${day}T01:20:00Z")),
                WebRequest(Instant.parse("${day}T01:18:00Z"), Instant.parse("${day}T01:19:00Z"))
        )

        println(getMaxConcurrent(reqs))
    }

    fun getMaxConcurrent(requests: List<WebRequest>): Int {
        val requestsFlattened =
                requests.flatMap { r -> listOf(WebRequestFlattened(r.start, "start"), WebRequestFlattened(r.end, "end")) }
                        .sortedBy { r -> r.time }

        var max = 0

        var curr = 0
        for (record in requestsFlattened) {
            if (record.state == "end") {
                curr -= 1
            } else {
                curr += 1
            }
            if (curr > max) {
                max = curr
            }
        }

        return max
    }
}