import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class FileOrganizer {

    // Map to store file extensions and their corresponding folder names
    private static final Map<String, String> FILE_TYPE_MAPPING = new HashMap<>();

    // Initialize file type mappings
    static {
        // Images
        FILE_TYPE_MAPPING.put("jpg", "Images");
        FILE_TYPE_MAPPING.put("jpeg", "Images");
        FILE_TYPE_MAPPING.put("png", "Images");
        FILE_TYPE_MAPPING.put("gif", "Images");
        FILE_TYPE_MAPPING.put("bmp", "Images");
        FILE_TYPE_MAPPING.put("svg", "Images");
        FILE_TYPE_MAPPING.put("webp", "Images");

        // Audio
        FILE_TYPE_MAPPING.put("mp3", "Audio");
        FILE_TYPE_MAPPING.put("wav", "Audio");
        FILE_TYPE_MAPPING.put("flac", "Audio");
        FILE_TYPE_MAPPING.put("aac", "Audio");
        FILE_TYPE_MAPPING.put("ogg", "Audio");
        FILE_TYPE_MAPPING.put("wma", "Audio");

        // Video
        FILE_TYPE_MAPPING.put("mp4", "Video");
        FILE_TYPE_MAPPING.put("avi", "Video");
        FILE_TYPE_MAPPING.put("mkv", "Video");
        FILE_TYPE_MAPPING.put("mov", "Video");
        FILE_TYPE_MAPPING.put("wmv", "Video");
        FILE_TYPE_MAPPING.put("flv", "Video");
        FILE_TYPE_MAPPING.put("webm", "Video");

        // Documents
        FILE_TYPE_MAPPING.put("pdf", "Documents");
        FILE_TYPE_MAPPING.put("doc", "Documents");
        FILE_TYPE_MAPPING.put("docx", "Documents");
        FILE_TYPE_MAPPING.put("txt", "Documents");
        FILE_TYPE_MAPPING.put("odt", "Documents");
        FILE_TYPE_MAPPING.put("rtf", "Documents");

        // Spreadsheets
        FILE_TYPE_MAPPING.put("xls", "Spreadsheets");
        FILE_TYPE_MAPPING.put("xlsx", "Spreadsheets");
        FILE_TYPE_MAPPING.put("csv", "Spreadsheets");
        FILE_TYPE_MAPPING.put("ods", "Spreadsheets");

        // Presentations
        FILE_TYPE_MAPPING.put("ppt", "Presentations");
        FILE_TYPE_MAPPING.put("pptx", "Presentations");
        FILE_TYPE_MAPPING.put("odp", "Presentations");

        // Archives
        FILE_TYPE_MAPPING.put("zip", "Archives");
        FILE_TYPE_MAPPING.put("rar", "Archives");
        FILE_TYPE_MAPPING.put("7z", "Archives");
        FILE_TYPE_MAPPING.put("tar", "Archives");
        FILE_TYPE_MAPPING.put("gz", "Archives");

        // Code
        FILE_TYPE_MAPPING.put("java", "Code");
        FILE_TYPE_MAPPING.put("py", "Code");
        FILE_TYPE_MAPPING.put("js", "Code");
        FILE_TYPE_MAPPING.put("cpp", "Code");
        FILE_TYPE_MAPPING.put("c", "Code");
        FILE_TYPE_MAPPING.put("html", "Code");
        FILE_TYPE_MAPPING.put("css", "Code");
        FILE_TYPE_MAPPING.put("php", "Code");
        FILE_TYPE_MAPPING.put("rb", "Code");
        FILE_TYPE_MAPPING.put("go", "Code");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     FILE ORGANIZER v1.0");
        System.out.println("=================================");
        System.out.println();

        // Get folder path from user
        System.out.print("Enter the folder path to organize: ");
        String folderPath = scanner.nextLine().trim();

        // Validate the folder
        File folder = new File(folderPath);
        if (!folder.exists()) {
            System.out.println("❌ Error: The specified folder does not exist.");
            scanner.close();
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("❌ Error: The specified path is not a directory.");
            scanner.close();
            return;
        }

        // Start organizing files
        System.out.println("\n📁 Starting file organization...\n");
        organizeFiles(folder);

        scanner.close();
    }

    /**
     * Main method to organize files in the given directory
     */
    private static void organizeFiles(File folder) {
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("ℹ️ No files found in the directory.");
            return;
        }

        int movedCount = 0;
        int skippedCount = 0;

        for (File file : files) {
            // Skip directories
            if (file.isDirectory()) {
                continue;
            }

            // Get file extension
            String extension = getFileExtension(file.getName());

            if (extension.isEmpty()) {
                System.out.println("⚠️ Skipped: " + file.getName() + " (no extension)");
                skippedCount++;
                continue;
            }

            // Classify file type
            String folderName = classifyFileType(extension);

            // Create target directory if it doesn't exist
            File targetDir = new File(folder, folderName);
            if (!targetDir.exists()) {
                if (targetDir.mkdir()) {
                    System.out.println("📁 Created folder: " + folderName + "/");
                } else {
                    System.out.println("❌ Failed to create folder: " + folderName);
                    continue;
                }
            }

            // Move the file
            File targetFile = new File(targetDir, file.getName());
            if (moveFile(file, targetFile)) {
                System.out.println("✓ Moved: " + file.getName() + " → " + folderName + "/");
                movedCount++;
            } else {
                System.out.println("❌ Failed to move: " + file.getName());
                skippedCount++;
            }
        }

        // Display summary
        System.out.println("\n=================================");
        System.out.println("✅ File organization complete!");
        System.out.println("📊 Summary:");
        System.out.println("   - Files moved: " + movedCount);
        System.out.println("   - Files skipped: " + skippedCount);
        System.out.println("=================================");
    }

    /**
     * Helper method to extract file extension from filename
     */
    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');

        // No extension found
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return "";
        }

        // Extract extension (without the dot) and convert to lowercase
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }

    /**
     * Classify file type based on extension using switch statement
     */
    private static String classifyFileType(String extension) {
        // Check if extension exists in our mapping
        String folderName = FILE_TYPE_MAPPING.get(extension);

        if (folderName != null) {
            return folderName;
        }

        // For unmapped extensions, use switch for additional categorization
        switch (extension) {
            case "exe":
            case "msi":
            case "app":
            case "deb":
            case "rpm":
                return "Applications";

            case "iso":
            case "img":
            case "dmg":
                return "DiskImages";

            default:
                return "Others";
        }
    }

    /**
     * Move file to target location
     */
    private static boolean moveFile(File source, File target) {
        // Check if target file already exists
        if (target.exists()) {
            System.out.println("⚠️ File already exists in target: " + target.getName());
            return false;
        }

        // Attempt to move the file
        return source.renameTo(target);
    }
}