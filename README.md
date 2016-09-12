# README #

## About ##

### In one sentence ###

Providing good looking Swing UIComponents that should have been in the box.

### A little more & motivation ###

* Though using Swing and AWT many pretty things can be somehow created, I found myself using some patterns over and over again. This library aims to simplify reuse of these custom components.

## Features ##

### Pro ###

* Good looking, custom background, anti-aliased toggelable buttons. 

### Con ###

## How do I get set up? ##

### Old School ###
* Checkout this repo
* Integrate the included sources (src) or JAR (target) into your project

### Maven ###
* Add the following to your pom.xml (somewhere within the ```<project>``` block)

```
<repositories>
	[...]
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
	[...]
</repositories>

[...]

<dependencies>
	[...]
	<dependency>
		<groupId>com.github.m5c</groupId>
		<artifactId>mtypeuitools</artifactId>
		<version>-SNAPSHOT</version>
	</dependency>
	[...]
</dependencies>
```

## How do I use SafeSockets? ##

Either use the components as provided, or inherite from them. The rest is up to you.
