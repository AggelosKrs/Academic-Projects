# Eκφράζει τον όροφο του σπιτιού ή πολυκατοικίας
orofos = 3  # Θέλουμε να υπολογίσουμε μέχρι τον 3ο όροφο
# Kάθε όροφος έχει 18 σκαλιά
skales_orofou = 18
# Σκάλες ισογείου
skales_isogiou = 5
# Γιακάθε ένα σκαλί δαπανάμε κάποιες θερμίδες
calories_pskales = 0.15
calories = 0

for i in range(orofos + 1): # Θα εκτελεστεί για i=0, 1, 2, 3
    if i == 0:
        # i=0: Υπολογισμός σκαλιών ισογείου
        calories = calories + (skales_isogiou * calories_pskales)
    else:
        # i=1, 2, 3: Υπολογισμός σκαλιών ορόφων
        calories = calories + (skales_orofou * calories_pskales)

print(f"Οι θερμίδες που καταναλώνεις για να φτάσεις στον όροφο είναι: {calories}") 