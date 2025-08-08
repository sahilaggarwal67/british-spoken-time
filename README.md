# British Spoken Time Formatter

A Java application that converts a given time into its spoken equivalent in different styles (e.g., British style, can be easily expanded for others).  
It supports multiple output styles and is easily extensible for additional formats.

---

## Features
- Convert digital time into human-readable spoken form.
- CLI mode with interactive style selection if no arguments are provided.
- Built with **Java**
- Extensible architecture — add new styles by implementing a single interface.
- Uses Java `Locale` for formatter selection.

---

## Prerequisites
- **Java 17** or higher installed and available on `PATH`.
- **Apache Maven 3.8+** installed.
- Basic familiarity with running commands in a terminal.

---

## Build Instructions
Clone the repository and run:
```bash
mvn clean package
```
This will produce an executable JAR in the `target` directory:
```
target/british-spoken-time-1.0.1-jar-with-dependencies.jar
```

---

## Usage
### Syntax
```bash
java -jar target/british-spoken-time-1.0.1-jar-with-dependencies.jar <time> <style>
```
- `<time>` — time in `HH:mm` format (24-hour clock).
- `<style>` — the spoken time style (case-insensitive).

### Example
```bash
java -jar target/british-spoken-time-1.0.1-jar-with-dependencies.jar 6:15 british
```
Output:
```
quarter past six
```

---

### Interactive Mode
If you run the program **without arguments**, it will:
1. Display all available styles.
2. Prompt you to select one.
3. Prompt for time input.

```bash
java -jar target/british-spoken-time-1.0.1-jar-with-dependencies.jar
```
Example prompt:
```
Available styles:
1. british

Enter style:
```

---

## Available Styles
| Style     | Description |
|-----------|-------------|
| british   | Traditional British spoken time format (e.g., "quarter past six", "twenty to seven"). |

---

## Extending the Application
To add a new style:
1. Implement the `SpokenTimeFormatter` interface.
2. Register this in SpokenTimeFormatterFactory (In spring boot, we can use Constructor injection of list of SpokenTimeFormatter)

---

## Running Tests
This project includes unit tests for format style:
```bash
mvn test
```

---

## Example Outputs
| Input   | Style    | Output              |
|---------|----------|---------------------|
| 6:00    | british  | six o'clock         |
| 6:15    | british  | quarter past six    |
| 6:32    | british  | twenty eight to seven |
| 6:32    | literal  | six thirty two      |

---

## Design Patterns Used
- **Factory Pattern** — `SpokenTimeFormatterFactory` to select formatter at runtime.
- **Strategy Pattern** — Each formatter is a separate strategy for formatting spoken time.

---
