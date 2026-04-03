# 🏏 Cricket Match Simulator (Java)

A console-based cricket match simulation system built using **Java** following clean **Low-Level Design (LLD)** principles.

This project simulates real-world cricket mechanics including ball-by-ball gameplay, innings progression, strike rotation, extras (wide/no-ball), and professional scorecard generation.

---

## 🚀 Features

* ✅ Ball-by-ball match simulation
* ✅ Two innings with target chasing
* ✅ Batting & Bowling order input
* ✅ Wide and No-ball handling (extras)
* ✅ Strike rotation logic
* ✅ Wicket handling with dismissal info
* ✅ Batting Scorecard (Runs, Balls, 4s, 6s, Strike Rate)
* ✅ Bowling Scorecard (Overs, Runs, Wickets, Economy)
* ✅ Extras tracking (wide, no-ball)
* ✅ Run Rate & Overs calculation
* ✅ Cricbuzz-style formatted output

---

## 🧠 LLD Design

The project follows clean layered architecture:

Main
→ MatchService
→ InningsService
→ OverService
→ BallService

Entities:

* Player
* Team
* Ball
* Over
* Innings
* Match

Design Principles:

* ✔ Separation of concerns
* ✔ Encapsulation
* ✔ Domain-driven design
* ✔ Scalable architecture

---

## 📸 Sample Output

```
+--------------------------------------------------+
|                 INDIA INNINGS                    |
+--------------------------------------------------+

BATTING
----------------------------------------------------
Batsman           Dismissal           R   B   4s  6s  SR
----------------------------------------------------
a                 Not Out             13  3   1   1   433.33
d                 b q                 13  4   1   1   325.00

BOWLING
----------------------------------------------------
Bowler            O     R   W   Eco
----------------------------------------------------
q                 1.5   26  3   17.33

----------------------------------------------------
Extras: (w 0, nb 0) 0
Total: 26/3 (1.5 Ov)
Run Rate: 17.33
----------------------------------------------------
```

---

## 🛠️ Tech Stack

* Java
* OOP
* Low-Level Design (LLD)

---

## ▶️ How to Run

1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Run `Main.java`
4. Follow console instructions

---

## 🔮 Future Improvements

* 🎯 Commentary system (ball-by-ball text)
* 📊 Player performance analytics
* 🎲 Probability-based simulation
* 🌐 REST API using Spring Boot
* 🎨 GUI / Web interface

---

## 💡 Learning Outcomes

* Applied real-world **LLD concepts**
* Designed a **scalable system**
* Implemented **cricket rules accurately**
* Built **structured console UI**

---

## 👨‍💻 Author

Naveen
