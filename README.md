# 🚗 Auto Loan Calculator (JavaFX)

A **JavaFX-based desktop app** that calculates auto loan payments based on the car’s price, down payment, interest rate, and add-ons. The app provides a quick breakdown of monthly, total, and loan payments through a clean graphical interface.

---

## ✨ Features
- Calculate **monthly**, **total**, and **loan** payments
- Adjustable **loan terms**: 24, 36, 48, or 60 months
- Optional add-ons:
  - Rear Camera ($340)
  - Sunroof ($1510)
  - Touchscreen ($470)
- Auto-applied **7% sales tax**
- **Reset** button to clear all inputs
- Handles invalid or missing input values gracefully

---

## 🧮 How It Works
1. Enter the **base price**, **down payment**, and **sales tax**.  
2. Choose desired **loan term** and optional **add-ons**.  
3. Click **Calculate** to view results.

**Loan Formula:**
\[
\{Monthly Payment} = P \times \frac{r(1 + r)^n}{(1 + r)^n - 1}
\]
Where:
- `P` = Total Loan Amount  
- `r` = Monthly Interest Rate  
- `n` = Number of Months  

---

## 🗂️ File Structure
project/
├── App.java # Main JavaFX entry point
├── Controller.java # Handles UI and event logic
├── main.fxml # Layout file for the GUI
└── module-info.java # JavaFX module configuration


---

## ▶️ How to Run
1. Open the project in **IntelliJ** or **Eclipse**.  
2. Ensure **JavaFX SDK 17+** is configured in your project settings.  
3. Run the `App.java` file.  
4. If needed, add the following VM option:

---

**Author:** Ibigoni Inye-Tam  
**Project:** Auto Loan Calculator (JavaFX)

