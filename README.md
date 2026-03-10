# 🍄 Mario Java Tips

> *Learn Java through the Mushroom Kingdom!*

A fun web application created to celebrate **Mario Bros Day (March 10)** that teaches Java features from recent releases through Mario-themed tips.

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk)
![Vaadin](https://img.shields.io/badge/Vaadin-24-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-build-orange?style=for-the-badge&logo=apachemaven)
![Deploy](https://img.shields.io/badge/Deploy-Railway-purple?style=for-the-badge)

---

## ✨ Features

- 🎲 **Random tip display** — shows one Java tip at a time, no repeats until all are seen
- 📋 **Copy to LinkedIn** — formats the tip automatically for posting on LinkedIn
- 🌙 **Dark / Light mode** — toggle with session persistence
- 🏷️ **Version badge** — each tip shows which Java version it refers to
- 📱 **Responsive** — works on desktop and mobile

---

## ☕ Java Topics Covered

| Version | Features |
|---------|----------|
| Java 21 | Virtual Threads, Pattern Matching for switch, Record Patterns, Sequenced Collections |
| Java 22 | Unnamed Variables, String Templates, Foreign Function & Memory API |
| Java 23 | Primitive types in patterns, Markdown in Javadoc |
| Java 24 | Stream Gatherers, Scoped Values, Structured Concurrency |

---

## 🚀 Running locally

### Prerequisites
- Java 21+
- Maven 3.8+

### Steps

```bash
# Clone the repository
git clone https://github.com/your-username/mario-java-tips.git
cd mario-java-tips

# Run the application
mvn spring-boot:run
```

Access at: `http://localhost:8080`

---

## 🐳 Running with Docker

```bash
# Build the image
docker build -t mario-java-tips .

# Run the container
docker run -p 8080:8080 mario-java-tips
```

---

## ☁️ Deploy on Railway

1. Push the project to a GitHub repository
2. Access [railway.app](https://railway.app) and login with GitHub
3. Click **New Project → Deploy from GitHub repo**
4. Select this repository — Railway will detect the Dockerfile automatically
5. Go to **Settings → Domains → Generate Domain** to get a public URL

> The free tier gives $5/month in credits, which is enough for this app.

---

## 🛠️ Tech Stack

- **Backend + Frontend:** Java 21 + Vaadin 24
- **Build:** Maven
- **Containerization:** Docker
- **Deploy:** Railway / Render

---

## 👩‍💻 Author

Made with ☕ by [Leticia Amancio](https://www.linkedin.com/in/leticiaamancio/)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
