package io.github.lostbalckknight.script;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;

/**
 * Maven仓库清理工具
 *
 * @author chensixiang chensixiang1234@gmail.com
 */
public class MavenRepositoryClearUtils {

    public static void main(String[] args) throws IOException {
        // Maven仓库的路径
        Path path = Paths.get("E:/maven/repository");
        // Maven仓库清理前的大小
        long start = System.currentTimeMillis();
        long startSize = startMavenRepositorySizeOnWindows(path);
        System.out.println("===========开始===========");
        System.out.println(getMB(startSize));
        System.out.println(getGB(startSize));
        // Maven仓库清理后的大小
        long endSize = endMavenRepositorySizeOnWindows(path);
        long end = System.currentTimeMillis();
        System.out.println("===========结束===========");
        System.out.println(getMB(endSize));
        System.out.println(getGB(endSize));
        System.out.println("===========时间===========");
        long seconds = TimeUnit.MILLISECONDS.toSeconds(end - start);
        System.out.println("Second: " + seconds + "s");
    }

    public static long startMavenRepositorySizeOnWindows(Path path) throws IOException {
        MavenFileVisitorOnWindowsToGetSize toGetSize = new MavenFileVisitorOnWindowsToGetSize();
        Files.walkFileTree(path, toGetSize);
        return toGetSize.getSize();
    }

    public static long endMavenRepositorySizeOnWindows(Path path) throws IOException {
        MavenFileVisitorOnWindows1 visitor1 = new MavenFileVisitorOnWindows1();
        MavenFileVisitorOnWindows2 visitor2 = new MavenFileVisitorOnWindows2();
        MavenFileVisitorOnWindowsToGetSize toGetSize = new MavenFileVisitorOnWindowsToGetSize();
        Files.walkFileTree(path, visitor1);
        Files.walkFileTree(path, visitor2);
        Files.walkFileTree(path, toGetSize);
        return toGetSize.getSize();
    }

    public static class MavenFileVisitorOnWindowsToGetSize extends SimpleFileVisitor<Path> {
        private long size = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            size += Files.size(file);
            return super.visitFile(file, attrs);
        }

        public long getSize() {
            return size;
        }
    }

    public static class MavenFileVisitorOnWindows1 extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().contains("error") || file.toString().contains("unknown")) {
                Files.deleteIfExists(file);
            }
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            if (dir.toString().contains("error") || dir.toString().contains("unknown")) {
                Files.deleteIfExists(dir);
            }
            return super.postVisitDirectory(dir, exc);
        }
    }

    public static class MavenFileVisitorOnWindows2 extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().contains("lastUpdated")) {
                Files.deleteIfExists(file);
            }
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            long count = Files.list(dir).count();
            if (count == 0) {
                Files.deleteIfExists(dir);
            }
            return super.postVisitDirectory(dir, exc);
        }
    }

    public static String getMB(long size) {
        BigDecimal span = new BigDecimal(1024);
        BigDecimal res = new BigDecimal(size)
                .divide(span, MathContext.DECIMAL64)
                .divide(span, MathContext.DECIMAL64)
                .setScale(4, BigDecimal.ROUND_DOWN);
        return "MB: " + res + "MB";
    }

    public static String getGB(long size) {
        BigDecimal span = new BigDecimal(1024);
        BigDecimal res = new BigDecimal(size)
                .divide(span, MathContext.DECIMAL64)
                .divide(span, MathContext.DECIMAL64)
                .divide(span, MathContext.DECIMAL64)
                .setScale(4, BigDecimal.ROUND_DOWN);
        return "GB: " + res + "GB";
    }
}
