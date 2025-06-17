### Hexlet tests and linter status:
[![Actions Status](https://github.com/GishebetMaksim/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/GishebetMaksim/java-project-71/actions)
[![Java CI](https://github.com/GishebetMaksim/java-project-71/actions/workflows/gradle.yml/badge.svg)](https://github.com/GishebetMaksim/java-project-71/actions/workflows/gradle.yml)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=GishebetMaksim_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=GishebetMaksim_java-project-71)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=GishebetMaksim_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=GishebetMaksim_java-project-71)

This program determines the difference between two data structures.  
Utility features:  
· Support for different input formats: `yaml` and `json`  
· Report generation in `plain`, `stylish`, and `json` formats

---

## 🔧 Usage Example

### Plain format

```bash
./build/install/app/bin/app --format plain path/to/file.yml another/path/file.json
```

Output:

```
Property 'follow' was added with value: false  
Property 'baz' was updated. From 'bas' to 'bars'  
Property 'group2' was removed
```

---

### Stylish format

```bash
./build/install/app/bin/app filepath1.json filepath2.json
```

Output:

```
{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```

---
