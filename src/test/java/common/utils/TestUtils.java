package common.utils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TestUtils {

    private static final Pattern ARRAY_2D = Pattern.compile("(\\d+),(\\d+)");

    public static int[][] array2d(String source) {
        source = source.substring(1, source.length() - 1);
        Matcher matcher = ARRAY_2D.matcher(source);
        return matcher.results().map(result ->
            new int[]{Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))}
        ).toList().toArray(new int[][]{});
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
