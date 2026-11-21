# Student Management System

A console-based Java application for managing student records.

## Features

- Add, view, search, update, and delete students
- Search students by name
- Sort students by ID, name, or age
- Validate menu choices and numeric input
- Persist records to `students.dat`
- Write add, update, and delete events to `system.log`

## Run

From the project root:

```powershell
javac -encoding UTF-8 -d build (Get-ChildItem -Path .\src -Filter *.java -Recurse | ForEach-Object { $_.FullName })
java -cp build main.Main
```
