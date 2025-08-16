# Dank Polynomials

A Kotlin project for finding polynomials that generate consecutive prime numbers. This project explores the fascinating mathematical problem of discovering quadratic polynomials of the form `n² + an + b` that produce the longest sequences of consecutive primes.

## Features

- Prime number detection algorithms
- Polynomial evaluation and prime sequence generation
- Comprehensive test suite using Kotest
- Containerized development environment

## Prerequisites

- **Java 8** or higher
- **Gradle** (wrapper included)
- **Docker** (optional, for containerized development)

## Project Structure

```
DankPolynomials/    
├── gradlew                                 # Gradle wrapper script
├── gradle/wrapper/                         # Gradle wrapper files
├── settings.gradle.kts                     # Multi-module project settings
├── Dockerfile                              # Docker configuration
└── app/                                    # Main application module
    ├── build.gradle.kts                    # Build configuration
    └── src/
        ├── main/kotlin/com/dankpolynomials/
        │   ├── DankPolynomials.kt          # Core algorithms
        │   └── Main.kt                     # Application entry point
        └── test/kotlin/com/dankpolynomials/
            └── DankPolynomialsTest.kt      # Test suite
```

## Local Development

### Build the Project

```bash
./gradlew build
```

### Run the Application

```bash
./gradlew run
```

### Run Tests

```bash
./gradlew test
```

### Clean Build

```bash
./gradlew clean build
```

## Docker Development

The project includes a Dockerfile for consistent development environments across different machines.

### Build Docker Image

```bash
docker build -t dankpolynomials .
```

### Run Application in Container

```bash
docker run -it dankpolynomials
```

### Run Tests in Container

```bash
# Run tests with detailed output
docker run -it dankpolynomials ./gradlew test

# Clean and run tests
docker run -it dankpolynomials ./gradlew clean test

# Force test execution (ignore up-to-date checks)
docker run -it dankpolynomials ./gradlew test --rerun-tasks
```

### Interactive Development

```bash
# Start a shell inside the container
docker run -it dankpolynomials /bin/bash

# Then run any Gradle commands
./gradlew build
./gradlew test
./gradlew run
```

### Development with Volume Mounting

For active development, you can mount your local source code:

```bash
# Mount current directory for live code changes
docker run -it -v $(pwd):/app dankpolynomials /bin/bash
```

## Testing

This project uses [Kotest](https://kotest.io/) for testing, which provides:

- Property-based testing
- Powerful assertions
- Multiple testing styles
- JUnit 5 integration

### Test Structure

The test suite includes:
- Prime number detection tests
- Edge case handling
- Polynomial evaluation validation
- Performance benchmarks

### Sample Test Output

```
> Task :test
com.dankpolynomials.DankPolynomialsTest > isPrime should return true for prime numbers PASSED

com.dankpolynomials.DankPolynomialsTest > isPrime should return false for non-prime numbers PASSED

com.dankpolynomials.DankPolynomialsTest > isPrime should handle edge cases PASSED

com.dankpolynomials.DankPolynomialsTest > getBestPolynomial should return expected result STANDARD_OUT
    Best Polynomial: n² + -61n + 971, Consecutive Primes: 71

com.dankpolynomials.DankPolynomialsTest > getBestPolynomial should return expected result PASSED
Results: SUCCESS (4 tests, 4 passed, 0 failed, 0 skipped)
```

## Docker Image Details

- **Base Image**: Amazon Corretto 8 Alpine
- **Size**: Optimized for small footprint
- **Build Cache**: Leverages Gradle dependency caching
- **Multi-stage**: Separates dependency download from source compilation

### Docker Build Process

1. Downloads and caches Gradle dependencies
2. Compiles Kotlin source code
3. Runs the application by default
4. Can be overridden to run tests or other tasks

## Mathematical Background

This project explores quadratic polynomials that generate consecutive primes. The famous example is Euler's polynomial `n² + n + 41`, which generates 40 consecutive primes for `n = 0, 1, 2, ..., 39`.

The current implementation has found polynomials generating impressive sequences, such as:
- `n² + -61n + 971` producing 71 consecutive primes

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests: `./gradlew test`
5. Submit a pull request

## Development Notes

- The project uses Java 8 toolchain for compatibility
- Gradle wrapper ensures consistent build environment
- Docker provides isolated, reproducible builds
- Kotest enables comprehensive testing strategies

## Troubleshooting

### Common Issues

**Build fails with "Cannot find Java installation"**
```bash
# Ensure JAVA_HOME is set or use the Docker environment
docker run -it dankpolynomials ./gradlew build
```

**Tests show "UP-TO-DATE" but don't run**
```bash
# Force test execution
./gradlew test --rerun-tasks
# Or clean first
./gradlew clean test
```

**Docker build is slow**
- First build downloads all dependencies (normal)
- Subsequent builds use layer caching and are much faster
- Only source code changes trigger recompilation

## License

This project is open source. Feel free to explore, learn, and contribute to the fascinating world of polynomial prime generation!