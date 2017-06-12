__author__ = 'william.zhang'

class Person:
    def __init__(self, minval):
        self.minval = minval
    def is_greater_than(self, val):
        return val > self.minval
    def my_filter(lst, minval):
        helper = Person(minval)
        return filter(Person.is_greater_than, lst)


p = Person(13)
print(p.is_greater_than(15))