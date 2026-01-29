import math

print("=== Triangle Inspector (χωρίς συναρτήσεις) ===")

# Είσοδος: όλα σε μία γραμμή
points = input("x1,y1,x2,y2,x3,y3: ")
L = [float(t.strip()) for t in points.split(",")]
x1, y1, x2, y2, x3, y3 = L

# Υπολογισμός αποστάσεων πλευρών
ab = math.hypot(x2 - x1, y2 - y1)  # εναλλακτικά: math.sqrt((x2-x1)**2 + (y2-y1)**2)
bc = math.hypot(x3 - x2, y3 - y2)
ca = math.hypot(x1 - x3, y1 - y3)

print(f"AB = {ab:.4f}, BC = {bc:.4f}, CA = {ca:.4f}")

# Έλεγχος αν τα σημεία σχηματίζουν τρίγωνο (ανισότητες τριγώνου)
if (ab + bc > ca) and (bc + ca > ab) and (ca + ab > bc):

    # Περίμετρος και εμβαδόν (τύπος Ήρωνα)
    per = ab + bc + ca
    s = per / 2.0
    area = math.sqrt(s * (s - ab) * (s - bc) * (s - ca))

    # Τύπος κατά πλευρές
    if ab == bc and bc == ca:
        sides_type = "ισόπλευρο"
    elif ab == bc or bc == ca or ca == ab:
        sides_type = "ισοσκελές"
    else:
        sides_type = "σκαληνό"

    # Τύπος κατά γωνίες (με Πυθαγόρειο θεώρημα)
    a, b, c = sorted([ab, bc, ca])  # a ≤ b ≤ c

    # Στρογγυλοποιούμε τα τετράγωνα για να αποφύγουμε σφάλματα float
    left = round(a*a + b*b, 4)
    right = round(c*c, 4)

    if left == right:
        angles_type = "ορθογώνιο"
    elif left > right:
        angles_type = "οξυγώνιο"
    else:
        angles_type = "αμβλυγώνιο"

    # Εμφάνιση αποτελεσμάτων
    print("Έγκυρο τρίγωνο.")
    print(f"Περίμετρος = {per:.4f}")
    print(f"Εμβαδόν = {area:.4f}")
    print(f"Τύπος κατά πλευρές: {sides_type}")
    print(f"Τύπος κατά γωνίες: {angles_type}")
else:
    print("Τα σημεία δεν σχηματίζουν έγκυρο τρίγωνο.") 




