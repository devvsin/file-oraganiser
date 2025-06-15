# 📁 File Organizer

A powerful console-based Java application that automatically organizes files in any directory by sorting them into categorized subfolders based on their file extensions.

## ✨ Features

- 🚀 **Fast & Efficient**: Quickly scans and organizes hundreds of files
- 📂 **Smart Categorization**: Automatically sorts 40+ file types into appropriate folders
- 🛡️ **Safe Operation**: Checks for existing files to prevent overwrites
- 📊 **Detailed Logging**: Real-time progress updates and summary statistics
- 🎯 **No Dependencies**: Pure Java implementation with no external libraries
- 💻 **Cross-Platform**: Works on Windows, macOS, and Linux
- 🎨 **User-Friendly**: Clean console interface with emoji indicators

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher installed on your system
- Basic knowledge of using command line/terminal

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/devvsin/file-organizer.git
   cd file-organizer
   ```

2. **Compile the application**
   ```bash
   javac FileOrganizer.java
   ```

3. **Run the application**
   ```bash
   java FileOrganizer
   ```

## 📖 Usage

1. Run the application
2. Enter the path to the folder you want to organize
3. Watch as your files are automatically sorted!

### Example

```
=================================
     FILE ORGANIZER v1.0
=================================

Enter the folder path to organize: /Users/john/Downloads

📁 Starting file organization...

📁 Created folder: Images/
✓ Moved: vacation.jpg → Images/
✓ Moved: screenshot.png → Images/
📁 Created folder: Documents/
✓ Moved: report.pdf → Documents/
📁 Created folder: Audio/
✓ Moved: song.mp3 → Audio/

=================================
✅ File organization complete!
📊 Summary:
   - Files moved: 4
   - Files skipped: 0
=================================
```

## 📂 Supported File Types

| Category | Extensions |
|----------|------------|
| **Images** | jpg, jpeg, png, gif, bmp, svg, webp |
| **Audio** | mp3, wav, flac, aac, ogg, wma |
| **Video** | mp4, avi, mkv, mov, wmv, flv, webm |
| **Documents** | pdf, doc, docx, txt, odt, rtf |
| **Spreadsheets** | xls, xlsx, csv, ods |
| **Presentations** | ppt, pptx, odp |
| **Archives** | zip, rar, 7z, tar, gz |
| **Code** | java, py, js, cpp, c, html, css, php, rb, go |
| **Applications** | exe, msi, app, deb, rpm |
| **Disk Images** | iso, img, dmg |
| **Others** | Any unrecognized extensions |

## 🛠️ Technical Implementation

- **Language**: Java (Pure Java, no external dependencies)
- **File Operations**: Uses Java's `File` class and `renameTo()` method
- **Data Structure**: HashMap for efficient file type mapping
- **Design Pattern**: Single-class implementation with helper methods
- **Error Handling**: Comprehensive validation and error messages

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Ideas for Contribution

- Add support for more file types
- Implement custom categorization rules
- Add configuration file support
- Create a GUI version
- Add undo functionality
- Implement duplicate file detection

## ⚠️ Important Notes

- **Backup Important Data**: This tool moves files, not copies them
- **Test First**: Try on a test folder before organizing important directories
- **File Permissions**: Ensure you have proper permissions for the target directory
- **Active Files**: Close any programs using the files before organizing

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Inspired by the need to keep digital spaces organized

## 📞 Contact

- Create an issue for bug reports or feature requests
- Pull requests are always welcome

---

**⭐ If you find this project useful, please consider giving it a star!**
