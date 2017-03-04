package rxtest

import org.scalatest.FunSpec
import rx.Single
import rx.observers.TestSubscriber

class SingleTests extends FunSpec {

  describe("Single") {
    it("should emit at most one") {
      val s = Single.just("one")
      val sub = TestSubscriber.create[String]()
      s.subscribe(sub)
      sub.awaitTerminalEvent()
      sub.assertCompleted()
      sub.assertValue("one")
    }

    it("may emit a error notification") {
      val s = Single.error(new RuntimeException)
      val sub = TestSubscriber.create[String]()
      s.subscribe(sub)
      sub.awaitTerminalEvent()
      sub.assertError(classOf[RuntimeException])
    }

    it("should map the value to a new value") {
      val s: Single[Int] = Single.just(1)
      val s2 = s.map(_ * 2)
    }
  }
}
