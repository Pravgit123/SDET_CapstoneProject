class Student:
    def __init__(self, name, grade, age):
        self.name = name
        self.grade = grade
        self.age = age

    def display(self):
        print("Student Details:")
        print(f"Name: {self.name}")
        print(f"Grade: {self.grade}")
        print(f"Age: {self.age}")

class School(Student):
    def school_student_display(self):
        print("\nSchool Student Details:")
        print(f"Name: {self.name}")
        print(f"Grade: {self.grade}")
        print(f"Age: {self.age}")

# Example usage
# Create a Student object
student_obj = Student("John", "A", 18)
# Display student details
student_obj.display()

# Create a School object (inherits from Student)
school_student_obj = School("Alice", "B", 17)
# Display school student details
school_student_obj.school_student_display()
