grade = int(input("Enter your grade: "))
letter_grade = "Invalid"

# if grade >= 90 and grade <= 100:
#     letter_grade = "A"
# elif grade >= 80 and grade < 90:
#     letter_grade = "B"
# elif grade >= 70 and grade < 80:
#     letter_grade = "C"
# elif grade >= 60 and grade < 70:
#     letter_grade = "D"
# elif grade >= 0 and grade < 60:
#     letter_grade = "F"

if grade > 100 or grade < 0:
    letter_grade = "Invalid"
elif grade >= 90:
    letter_grade = "A"
elif grade >= 80:
    letter_grade = "B"
elif grade >= 70:
    letter_grade = "C"
elif grade >= 60:
    letter_grade = "D"
elif grade >= 0:
    letter_grade = "F"


print(letter_grade)
# if 90 <= grade <= 100: