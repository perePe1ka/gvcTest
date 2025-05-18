# Полная инструкция от DDL‑скрипта до запуска приложения

---

## 1. Что понадобится

| Компонент | Минимальная версия | Ссылка |
|-----------|-------------------|--------|
| **PostgreSQL** | 13 + | <https://www.postgresql.org/download/> |
| **JDK** | 17 + | <https://adoptium.net/> |
| **Maven** **или** **Gradle** | Maven 3.9 + / Gradle 8 + | |
| **Git** (опционально) | | для клонирования репозитория |

---

## 2. Создаём базу и загружаем данные

### 2.1 Файл *table_ja.sql*

```sql
CREATE DATABASE table_ja;
\c table_ja

CREATE TABLE IF NOT EXISTS railway_admins (
                                              code_ja      INTEGER  PRIMARY KEY,
                                              full_name_ja TEXT     NOT NULL,
                                              abbr_ja      CHAR(10) NOT NULL
    );

\copy railway_admins(code_ja, full_name_ja, abbr_ja) FROM '/home/perepe1ka/Загрузки/table_ja.csv' CSV HEADER DELIMITER ',' QUOTE '"';
```

> **Важно**: строку `FROM …` измените под ваш абсолютный путь.  
> На Windows пути выглядят так: `C:\Users\YOUR\path\table_ja.csv`.

### 2.2 Запуск скрипта

#### Linux / macOS

```bash
psql -U postgres -h localhost -p 5432 -f /home/USER/Downloads/table_ja.sql
```

#### Windows (PowerShell / cmd)

```powershell
psql -U postgres -h localhost -p 5432 -f "C:\Users\USER\Downloads\table_ja.sql"
```

Проверка:

```sql
\c table_ja
SELECT * FROM railway_admins;
```

---

## 3. Настраиваем Spring Boot

В `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/table_ja
    username: postgres
    password: ****          # ваш пароль
  jpa:
    hibernate:
      ddl-auto: none        # схему не трогаем
    open-in-view: false
```

---

## 4. Сборка и запуск

| Инструмент | Команды |
|------------|---------|
| **Maven**  | `./mvnw clean package`  →  `java -jar target/railway-admins-0.0.1-SNAPSHOT.jar` |
| **Gradle** | `./gradlew bootJar`     →  `java -jar build/libs/railway-admins-0.0.1-SNAPSHOT.jar` |

*Windows*: используйте `mvnw.cmd` / `gradlew.bat` вместо `./mvnw` / `./gradlew`.

---

## 5. Проверяем

* UI‑страница: <http://localhost:8080/admins>
* REST‑ручки:

  | Метод | URL | Описание |
    |-------|-----|----------|
  | `GET` | `/api/v1/admins` | все записи |
  | `GET` | `/api/v1/admins/{codeJa}` | одна запись |
  | `POST`| `/api/v1/admins` | создать |
  | `PUT` | `/api/v1/admins/{codeJa}` | обновить |
  | `DELETE` | `/api/v1/admins/{codeJa}` | удалить |

---

## 6. Шпаргалка путей для Windows

| Linux/macOS пример | Windows аналог |
|--------------------|---------------|
| `/home/USER/Downloads/table_ja.csv` | `C:\Users\USER\Downloads\table_ja.csv` |
| `/home/USER/Downloads/table_ja.sql` | `C:\Users\USER\Downloads\table_ja.sql` |
| `./mvnw` | `mvnw.cmd` |

---

## 7. Частые ошибки

| Сообщение | Причина | Решение |
|-----------|---------|---------|
| `\copy: parse error at end of line` | команда разбита на 2 строки | убедитесь, что `\copy …` в **одной** строке |
| `password authentication failed` | неверный пароль PostgreSQL | исправьте пароль в скрипте и `application.yml` |
| `Circular view path [admins]` | нет Thymeleaf или шаблона | добавьте стартер *thymeleaf* и `templates/admins.html` |
| `EntityNotFoundException` при `DELETE` | запись не существует | проверьте `codeJa` |

---

✔ Всё готово — запускайте, проверяйте UI и REST!
