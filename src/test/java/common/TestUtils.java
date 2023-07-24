package common;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestUtils {

    public static int[][] array2d(String source) {
        //source = source.substring(1, source.length() - 1);
        List<int[]> res = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;
        while ((startIdx = source.indexOf("[", startIdx + 1)) >= 0) {
            endIdx = source.indexOf("]", endIdx + 1);
            String arrSubstring = source.substring(startIdx + 1, endIdx);
            int[] e = Arrays.stream(arrSubstring.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            res.add(e);
        }
        return res.toArray(new int[][]{});
    }

    public static int[][] array2dFromClasspath(String packageName, String classpathResource) {
        return array2d(readFromClasspath(packageName, classpathResource));
    }

    private static String readFromClasspath(String packageName, String classpathResource) {
        String name = packageName + "/" + classpathResource;
        InputStream resourceAsStream = TestUtils.class.getClassLoader().getResourceAsStream(name);
        try {
            if (resourceAsStream == null) {
                throw new FileNotFoundException(classpathResource);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {
                StringBuilder sb = new StringBuilder(10 * 1024);
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
