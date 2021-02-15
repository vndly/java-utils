[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/java-utils/blob/master/LICENSE.md)

# Java Utils
A collection of Java utility classes.

## Installation

### Maven

Add the following code to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

And the dependency:

```xml
<dependency>
    <groupId>com.github.mauriciotogneri</groupId>
    <artifactId>java-utils</artifactId>
    <version>3.4.0</version>
</dependency>
```

### Gradle

Add the following code to your root `build.gradle`:

```groovy
allprojects
{
    repositories
    {
        maven
        {
            url 'https://jitpack.io'
        }
    }
}
```

Add the following code to your module `build.gradle`:
```groovy
implementation 'com.github.mauriciotogneri:java-utils:3.4.0'
```