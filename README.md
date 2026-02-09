# API Stub Homework (WireMock + Helpers)

## What service we test
We test a **local stub service** поднятый на **WireMock** (случайный порт во время тестов).
Он имитирует backend со следующими endpoint'ами:

### REST
- `GET /user/get/all` — список пользователей
- `GET /cource/get/all` — список курсов (endpoint оставлен как в ТЗ: `cource`)
- `GET /user/get/{id}` — оценка пользователя

### Stub frontend
- `GET /` — простая HTML-страница из `src/test/resources/__files/index.html`

### SOAP (для soap-helper)
- `POST /soap/user/getScore` — возвращает SOAP Envelope с `name` и `score`

## Project structure
- `linters/checkstyle.xml` — Checkstyle (severity=error)
- `src/test/java/stubs` — конфигурация WireMock stubs
- `src/test/java/helpers` — http-helper и soap-helper
- `src/test/java/tests` — JUnit5 тесты
- `src/test/resources/schemas` — JSON Schema файлы для валидации ответов
- `src/test/resources/__files` — статика для stub frontend

## How to run
```bash
./gradlew test
```

Reports:
- Checkstyle HTML: `build/reports/checkstyle/checkstyleTest.html`
