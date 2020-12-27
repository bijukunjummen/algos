package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToNameMap = createEmailToNameMap(accounts);
        Map<String, List<String>> graph = createGraph(accounts);
        Map<Integer, Set<String>> componentToEmails = new HashMap<>();

        int componentId = 0;
        Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                dfs(email, graph, componentId, componentToEmails, visited);
                componentId++;
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : componentToEmails.entrySet()) {
            Set<String> emailSet = entry.getValue();
            List<String> emails = emailSet.stream().sorted().collect(Collectors.toList());
            String name = emailToNameMap.get(emails.get(0));

            List<String> nameAndEmails = new ArrayList<>();
            nameAndEmails.add(name);
            nameAndEmails.addAll(emails);
            result.add(nameAndEmails);
        }
        return result;
    }

    private void dfs(String email, Map<String, List<String>> graph, int componentId, Map<Integer, Set<String>> componentToEmails, Set<String> visited) {
        if (visited.contains(email)) {
            return;
        }
        Set<String> emailsList = componentToEmails.computeIfAbsent(componentId, k -> new HashSet<>());
        emailsList.add(email);
        visited.add(email);

        for (String childEmail : graph.get(email)) {
            if (!visited.contains(childEmail)) {
                dfs(childEmail, graph, componentId, componentToEmails, visited);
            }
        }
    }

    private Map<String, List<String>> createGraph(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int id = 0; id < accounts.size(); id++) {
            List<String> account = accounts.get(id);
            graph.computeIfAbsent(account.get(1), k -> new ArrayList<>());
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.computeIfAbsent(email, k -> new ArrayList<>());
                graph.get(account.get(1)).add(email);
                graph.get(email).add(account.get(1));
            }
        }
        return graph;
    }

    private Map<String, String> createEmailToNameMap(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name);
            }
        }
        return emailToName;
    }

    @Test
    void testMerge() {
        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("John", "johnnybravo@mail.com"),
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("Mary", "mary@mail.com"));

        List<List<String>> result = List.of(
                List.of("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                List.of("John", "johnnybravo@mail.com"), List.of("Mary", "mary@mail.com"));
        assertThat(new HashSet<>(accountsMerge(accounts))).isEqualTo(new HashSet<>(result));
    }
}