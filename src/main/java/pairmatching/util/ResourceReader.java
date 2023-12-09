package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResourceReader {

    public List<String> readResource(String path) {
        List<String> resources = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String name = null;
            while((name = bufferedReader.readLine())!=null){
                resources.add(name);
            }
            return resources;
        } catch (IOException e){
            return Collections.emptyList();
        }
    }
}
