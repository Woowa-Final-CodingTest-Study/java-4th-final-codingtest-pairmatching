package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.InternalErrorMessage;

public class FileManager {

    public static Stream<String> read(String fileName) throws IOException {
        try {
            return Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            throw new IOException(InternalErrorMessage.READ_FILE_FAILED);
        }
    }
}
