import math

def read_points():
    points = input("x1,y1,x2,y2,x3,y3: ")
    L = [float(t.strip()) for t in points.split(",")]
    return (L[0], L[1]), (L[2], L[3]), (L[4], L[5])

def distance(p, q):
    #συμπληρώστε εδώ (1ο σημείο)
    dist = math.hypot(p[0] - q[0] , p[1] - q[1])
    return dist

def is_valid_triangle(a, b, c):
    #συμπληρώστε εδώ (2ο σημείο) 
    #Θα γυρνάει ένα boolian
    return (ab + bc > ca) and (bc + ca > ab) and (ca + ab > bc) 


def perimeter(a, b, c):
    #συμπληρώστε εδώ (3ο σημείο)
    perimeter = a + b + c
    return perimeter

def area(a, b, c):
    #συμπληρώστε εδώ (4ο σημείο)
    #Αφού τα ορίσματα είναι a = AB, b = BA, c = CA όπως το αρχικό πρόγραμμα
    s = per / 2.0
    area = math.sqrt(s * (s - a) * (s - b) * (s - c))
    return area

def type_by_sides(a, b, c):
    if a == b == c:
        return "ισόπλευρο"
    if a == b or b == c or c == a:
        return "ισοσκελές"
    return "σκαληνό"

def type_by_angles(a, b, c):
    a, b, c = sorted([a, b, c])  # a ≤ b ≤ c

    # στρογγυλοποίηση για να αποφύγουμε σφάλματα κινητής υποδιαστολής
    left = round(a*a + b*b, 4)
    right = round(c*c, 4)

    if left == right:
        return "ορθογώνιο"
    return "οξυγώνιο" if left > right else "αμβλυγώνιο"

# --- main ---
print("=== Triangle Inspector (με συναρτήσεις) ===")
A, B, C = read_points()
                #(5ο σημείο συμπλήρωσης) 
ab = distance(A , B) #συμπληρώστε τις μεταβλητές κλήσης
bc = distance(B , C) #συμπληρώστε τις μεταβλητές κλήσης
ca = distance(C , A) #συμπληρώστε τις μεταβλητές κλήσης

print(f"AB={ab:.4f}, BC={bc:.4f}, CA={ca:.4f}")

if not is_valid_triangle(ab, bc, ca):
    print("Τα σημεία δεν σχηματίζουν έγκυρο τρίγωνο.")
else:
                                  #(6ο σημείο συμπλήρωσης)
    per = perimeter(ab, bc, ca)             #συμπληρώστε τις μεταβλητές κλήσης
    area_val = area(ab, bc, ca)             #συμπληρώστε τις μεταβλητές κλήσης 
    sides_t = type_by_sides(ab, bc, ca)     #συμπληρώστε τις μεταβλητές κλήσης
    angles_t = type_by_angles(ab, bc, ca)   #συμπληρώστε τις μεταβλητές κλήσης

    print("Έγκυρο τρίγωνο.")
    print(f"Περίμετρος = {per:.4f}")
    print(f"Εμβαδόν = {area_val:.4f}")
    print(f"Τύπος κατά πλευρές: {sides_t}")
    print(f"Τύπος κατά γωνίες: {angles_t}")
