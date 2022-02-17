package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

//save test results to txt file
public class TestLogger {

    private static final String MAIN_TEST_LOG_FILE = "test_results/test_summary.txt";
    private static final String DETAIL_TEST_LOG_FILE = "test_results/test_details.txt";

    private final Map<String,Boolean> results = new HashMap<>();

    public void logSingleTestResult(String testName, boolean passed) {
        results.put(testName,passed);
    }

    public void saveResults() {
        try {
            saveSummaryResult(getFilePath(MAIN_TEST_LOG_FILE));
            saveDetailedResults(getFilePath(DETAIL_TEST_LOG_FILE));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void saveSummaryResult(Path filePath) throws IOException {
        boolean overallTestResult = !results.containsValue(false);
        Files.writeString(filePath,
                "TASK COMPLETED:" + overallTestResult + "\n");
        long passedTestsCount = results.entrySet().stream().filter(Map.Entry::getValue).count();
        Files.writeString(filePath,
                "PASSED TESTS: " + passedTestsCount + " OF " + results.size() ,
                StandardOpenOption.APPEND);
    }

    private void saveDetailedResults(Path filePath) {
        results.forEach((key, value) -> {
            try {
                Files.writeString(filePath,
                        Instant.now() + ";" + key + ";" + value + "\n",
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private static Path getFilePath (String filePath) throws IOException {
        Path path = Path.of(filePath);
        if (Files.notExists(path)) Files.createFile(path);
        return path;
    }



}
