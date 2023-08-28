#!/usr/bin/env python3

def arithmetic_operations():
    # division / always returns a floating point number  ...
    result = 3 / 2
    type_of_result = type(result)
    print(f"3 / 2 = {result} is a {type_of_result.__name__}")
    assert type_of_result is float
    assert result == 1.5

    # even when the result is a natural number as in 4 / 2
    result = 4 / 2
    type_of_result = type(result)
    print(f"4 / 2 = {result} is a {type_of_result.__name__}")
    assert type_of_result is float
    assert result == 2.0

    # Floor division //
    # Mathematical division that rounds down to the nearest integer. The floor division
    # operator is //. For example, the expression 11 // 4 evaluates to 2 in contrast
    # to the 2.75 returned by float true division. Note that (-11) // 4 is -3 because
    # that is -2.75 rounded downward.
    result = 11 // 4
    type_of_result = type(result)
    print(f"11 // 4 = {result} is an {type_of_result.__name__}")
    assert type_of_result is int
    assert result == 2

    result = -11 // 4
    type_of_result = type(result)
    print(f"-11 // 4 = {result} is an {type_of_result.__name__}")
    assert type_of_result is int
    assert result == -3

    # Power operator is **, type of result depends on the operands
    # here both are int and result is int
    result = 2 ** 5
    type_of_result = type(result)
    print(f"2 ** 5 = {result} is an {type_of_result.__name__}")
    assert type_of_result is int
    assert result == 32

    # if any of them is float, result is float
    result = 2 ** 5.0
    type_of_result = type(result)
    print(f"2.0 ** 5 = {result} is a {type_of_result.__name__}")
    assert type_of_result is float
    assert result == 32.0

    result = 2 * 5
    type_of_result = type(result)
    print(f"2 * 5 = {result} is an {type_of_result.__name__}")
    assert type_of_result is int
    assert result == 10

    # for mixed type operands, all operands are converted to float and
    # the result is float
    result = 2 * 5 - 1.2
    type_of_result = type(result)
    print(f"2 * 5 = {result} is a {type_of_result.__name__}")
    assert type_of_result is float
    assert result == 8.8


def text_handling():
    # strings are of type str
    s = "this is a string"
    assert type(s) is str

    # can use single or double quotes for string literals
    s = 'this is a string'
    assert type(s) is str

    # escaping special characters
    s = 'string with "double quotes" in it'
    print(s)

    s = "string with \"double quotes\" escaped"
    print(s)

    s = "string with 'single quotes' in it"
    print(s)

    s = 'string with \'single quotes\' escaped and "double quotes" as well'
    print(s)

    s = r"raw strings preserve backslashes, e.g.: C:\windows\system32"
    print(s)

    s = r"backslash \ preserved"
    print(s)

    # String literals can span multiple lines. One way is using triple-quotes:
    # """...""" or '''...'''. End of lines are automatically included in the
    # string, but it’s possible to prevent this by adding a \ at the end of the
    # line.
    s = """
        Usage: thingy [OPTIONS]
            -h                        Display this usage message
            -H hostname               Hostname to connect to
    """
    print(s)

    # use textwrap.dedent to remove the indentation
    from textwrap import dedent
    print(dedent(s))

    # format a string with variables
    s = "String with a number: %d" % 5
    print(s)

    s = "String with another string: %s" % "another one here"
    print(s)

    s = "String with parameters specified in multi lines: %d %s %.2f" % (
        5,
        "foo",
        2.12345)
    print(s)

    s = '''
    Multi line string with "double quotes" and 'single quotes'
    and some backslashes \ preserved \ with multiple parameters: %d %s %.2f
    ''' % (5, "foo", 2.12345)
    print(dedent(s))

    # Strings can be concatenated (glued together) with the + operator
    # and repeated with *:
    s = 3 * 'un' + 'ium'
    print(s)
    assert s == "unununium"

    s = 'un' * 5 + 'ium'
    print(s)
    assert s == "unununununium"

    # Two or more string literals next to each other are automatically concatenated.
    s = "Py" "thon"
    print(s)
    assert s == "Python"

    # does not matter how far they are apart
    s = "Py"                 "thon"
    print(s)
    assert s == "Python"

    # use parenthesis for multiple lines
    s = ("Py"
         "thon" " is "
         "fun")
    print(s)
    assert s == "Python is fun"

    s = (s +
         " isn't "
         "it?")
    print(s)
    assert s == "Python is fun isn't it?"

    # Strings can be indexed (subscripted), with the first character having
    # index 0. There is no separate character type; a character is simply a
    # string of size one:
    s = "Python"
    assert s[0] == 'P'
    assert s[1] == 'y'
    assert s[2] == 't'
    assert s[3] == 'h'
    assert s[4] == 'o'
    assert s[5] == 'n'

    # Indices may also be negative numbers, to start counting from the right:
    # (Note that since -0 is the same as 0, negative indices start from -1)
    s = "Python"
    assert s[-6] == 'P'
    assert s[-5] == 'y'
    assert s[-4] == 't'
    assert s[-3] == 'h'
    assert s[-2] == 'o'
    assert s[-1] == 'n'

    # In addition to indexing, slicing is also supported. While indexing is used
    # to obtain individual characters, slicing allows you to obtain substrings.
    # Slice indices have useful defaults; an omitted first index defaults to
    # zero, an omitted second index defaults to the size of the string being
    # sliced.
    #  +---+---+---+---+---+---+
    #  | P | y | t | h | o | n |
    #  +---+---+---+---+---+---+
    #  0   1   2   3   4   5   6
    # -6  -5  -4  -3  -2  -1
    s = "Python"
    assert s[0:2] == "Py"
    assert s[2:5] == "tho"
    assert s[:2] == "Py"
    assert s[4:] == "on"
    assert s[-2:] == "on"

    # out of range indexes raise an IndexError: string index out of range
    s = "Python"
    try:
        print(s[1000])
        assert False  # should not fall down here
    except IndexError:
        pass

    try:
        print(s[-1000])
        assert False  # should not fall down here
    except IndexError:
        pass

    # out of range slice indexes are handled gracefully when used for slicing:
    assert s[4:42] == "on"
    assert s[100:300] == ""
    assert s[-100:-300] == ""
    assert s[-100:3] == "Pyt"
    assert s[-100:100] == "Python"

    # Python strings cannot be changed — they are immutable. Therefore, assigning
    # to an indexed position in the string results in a:
    # TypeError: 'str' object does not support item assignment
    s = "Python"
    try:
        s[0] = 'a'
        assert False  # should not fall down here
    except TypeError:
        pass

    # The built-in function len() returns the length of a string
    s = "Python"
    assert len(s) == 6


def list_operations():
    # Python knows a number of compound data types, used to group together other
    # values. The most versatile is the list, which can be written as a list of
    # comma-separated values (items) between square brackets. Lists might contain
    # items of different types, but usually the items all have the same type.
    squares = [1, 4, 9, 16, 25]
    print(squares)

    # Like strings (and all other built-in sequence types), lists can be indexed
    # and sliced:
    squares = [1, 4, 9, 16, 25]
    assert squares[0] == 1
    assert squares[-1] == 25
    assert squares[-3:] == [9, 16, 25]
    assert squares[1:-2] == [4, 9]

    # All slice operations return a new list containing the requested elements.
    # This means that the following slice returns a shallow copy of the list:
    squares = [1, 4, 9, 16, 25]
    new_list = squares[:]
    print(new_list)
    assert squares == new_list  # compares elements, thus equal until one is modified
    new_list[0] = 0  # this will not change squares[0]
    assert squares != new_list
    assert squares[0] == 1
    assert new_list[0] == 0

    # Lists also support operations like concatenation:
    list1 = [1, 2, 3]
    list2 = [4, 5, 6, 7]
    assert list1 + list2 == [1, 2, 3, 4, 5, 6, 7]

    # Unlike strings, which are immutable, lists are a mutable type, i.e. it is
    # possible to change their content:
    cubes = [1, 8, 27, 65, 125]
    cubes[3] = 4**3  # update element at index 3
    assert cubes == [1, 8, 27, 64, 125]

    # add new items at the end of the list, by using the append()
    squares = [1, 4, 9]
    squares.append(16)
    squares.append(25)
    assert squares == [1, 4, 9, 16, 25]

    # Assignment to slices is also possible, and this can even change the size
    # of the list or clear it entirely:
    letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
    letters[2:5] = ['C', 'D', 'E']
    print(letters)
    assert letters == ['a', 'b', 'C', 'D', 'E', 'f', 'g']
    letters[2:5] = []
    assert letters == ['a', 'b', 'f', 'g']
    letters[:] = []
    assert letters == []
    # The built-in function len() also applies to lists:
    assert len(letters) == 0

    # It is possible to nest lists (create lists containing other lists)
    a = ['a', 'b', 'c']
    n = [1, 2, 3]
    x = [a, n]
    assert x == [
        ['a', 'b', 'c'],
        [1, 2, 3],
    ]
    assert len(x) == 2

    # Extend the list by appending all the items from the iterable. Equivalent
    # to a[len(a):] = iterable.
    list1 = [1, 2, 3]
    list1.extend(range(4, 10))
    print(list1)
    assert list1 == [1, 2, 3, 4, 5, 6, 7, 8, 9]

    # Insert an item at a given position. The first argument is the index of the
    # element before which to insert, so a.insert(0, x) inserts at the front of
    # the list, and a.insert(len(a), x) is equivalent to a.append(x).
    list1 = [1, 2, 3]
    list1.insert(0, 0)
    assert list1 == [0, 1, 2, 3]
    list1.insert(2, 9)
    assert list1 == [0, 1, 9, 2, 3]

    # Remove the first item from the list whose value is equal to x. It raises a
    # ValueError if there is no such item.
    list1 = [1, 2, 3, 2]
    list1.remove(2)
    assert list1 == [1, 3, 2]

    list1 = [1, 2, 3, 4, 5]
    assert list1.pop() == 5
    assert list1.pop() == 4
    assert list1.pop(1) == 2
    assert list1.pop(0) == 1
    assert list1.pop() == 3
    assert list1 == []

    # Remove all items from the list. Equivalent to del a[:].
    list1 = [1, 2, 3]
    list1.clear()
    assert list1 == []

    list1 = [1, 2, 3]
    del list1[:]
    assert list1 == []

    # Return zero-based index in the list of the first item whose value is equal
    # to x. Raises a ValueError if there is no such item. The optional arguments
    # start and end are interpreted as in the slice notation and are used to
    # limit the search to a particular subsequence of the list. The returned
    # index is computed relative to the beginning of the full sequence rather
    # than the start argument. list.index(x[, start[, end]])
    list1 = [1, 2, 3, 2, 3, 5]
    assert list1.index(1) == 0
    assert list1.index(2) == 1
    assert list1.index(3) == 2
    assert list1.index(3, 3) == 4
    assert list1.index(3, 4, 5) == 4

    # Return the number of times x appears in the list. list.count(x)
    list1 = [1, 2, 3, 2, 3, 5, 2, 2, 2]
    assert list1.count(2) == 5

    # Sort the items of the list in place (the arguments can be used for sort
    # customization, see sorted() for their explanation).
    # list.sort(*, key=None, reverse=False)
    list1 = [3, 7, 2, 5, 9, 1, 4, 2]
    list1.sort()
    assert list1 == [1, 2, 2, 3, 4, 5, 7, 9]
    list1.sort(reverse=True)
    assert list1 == [9, 7, 5, 4, 3, 2, 2, 1]

    # Reverse the elements of the list in place. list.reverse()
    list1 = [1, 2, 3, 2, 3, 5]
    list1.reverse()
    assert list1 == [5, 3, 2, 3, 2, 1]

    # Return a shallow copy of the list. Equivalent to a[:]. list.copy()
    list1 = [1, 2, 3]
    list2 = list1.copy()
    assert list1 == list2
    list2[2] = 9
    assert list1 != list2
    assert list1 == [1, 2, 3]
    assert list2 == [1, 2, 9]
    list2 = list1[:]
    assert list1 == list2

    # The list methods make it very easy to use a list as a stack, where the
    # last element added is the first element retrieved (“last-in, first-out”).
    # To add an item to the top of the stack, use append(). To retrieve an item
    # from the top of the stack, use pop() without an explicit index
    stack = [3, 4, 5]
    stack.append(6)
    stack.append(7)
    assert stack == [3, 4, 5, 6, 7]
    assert stack.pop() == 7
    assert stack == [3, 4, 5, 6]
    assert stack.pop() == 6
    assert stack.pop() == 5
    assert stack == [3, 4]

    # It is also possible to use a list as a queue, where the first element
    # added is the first element retrieved (“first-in, first-out”); however,
    # lists are not efficient for this purpose. While appends and pops from the
    # end of list are fast, doing inserts or pops from the beginning of a list
    # is slow (because all of the other elements have to be shifted by one). To
    # implement a queue, use collections.deque which was designed to have fast
    # appends and pops from both ends. For example:

    from collections import deque
    queue = deque(["Eric", "John", "Michael"])
    queue.append("Terry")            # Terry arrives
    queue.append("Graham")           # Graham arrives
    assert queue.popleft() == 'Eric'  # The first to arrive now leaves
    assert queue.popleft() == 'John'  # The second to arrive now leaves
    # Remaining queue in order of arrival
    assert queue == deque(['Michael', 'Terry', 'Graham'])

    # List comprehensions provide a concise way to create lists. Common
    # applications are to make new lists where each element is the result of
    # some operations applied to each member of another sequence or iterable, or
    # to create a subsequence of those elements that satisfy a certain
    # condition.
    squares = list(map(lambda x: x**2, range(10)))
    assert squares == [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
    # or, equivalently (which is more concise and readable):
    squares = [x**2 for x in range(10)]
    assert squares == [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

    # A list comprehension consists of brackets containing an expression
    # followed by a for clause, then zero or more for or if clauses. The result
    # will be a new list resulting from evaluating the expression in the context
    # of the for and if clauses which follow it. For example, this listcomp
    # combines the elements of two lists if they are not equal:
    combinations = [(x, y) for x in [1, 2, 3] for y in [3, 1, 4] if x != y]
    assert combinations == [(1, 3), (1, 4), (2, 3),
                            (2, 1), (2, 4), (3, 1), (3, 4)]
    assert [(x, x**2) for x in range(6)] == [(0, 0), (1, 1), (2, 4),
                                             (3, 9), (4, 16), (5, 25)]

    vec = [[1, 2, 3],
           [4, 5, 6],
           [7, 8, 9],]
    assert [num for elem in vec for num in elem] == [1, 2, 3, 4, 5, 6, 7, 8, 9]

    # The following list comprehension will transpose rows and columns:
    matrix = [[1, 4, 7, 0],
              [2, 5, 8, 1],
              [3, 6, 9, 2],]
    transposed = [[row[i] for row in matrix] for i in range(len(matrix[0]))]
    assert transposed == [[1, 2, 3],
                          [4, 5, 6],
                          [7, 8, 9],
                          [0, 1, 2],]


def control_flow():
    # if statement
    # There can be zero or more elif parts, and the else part is optional.
    x = 1
    s = None
    if x < 0:
        x = 0
        s = "Negative changed to zero"
    elif x == 0:
        s = "Zero"
    elif x == 1:
        s = "Single"
    else:
        s = "More"

    print(s)
    assert s == "Single"

    # for loops
    # Python’s for statement iterates over the items of any sequence (a list or
    # a string), in the order that they appear in the sequence.
    words = ['cat', 'window', 'foo']
    for w in words:
        print(w, len(w))

    # Code that modifies a collection while iterating over that same collection
    # can be tricky to get right. Instead, it is usually more straight-forward
    # to loop over a copy of the collection or to create a new collection:
    # Create a sample collection
    users = {
        'Hans': 'active',
        'John': 'inactive',
        'Rebeca': 'active',
    }

    # Strategy:  Iterate over a copy
    for user, status in users.copy().items():
        if status == 'inactive':
            del users[user]

    # Strategy:  Create a new collection
    active_users = {}  # equivalent to dict()
    for user, status in users.items():
        if status == 'active':
            active_users[user] = status

    # use the built-in function range() to iterate over a sequence of numbers:
    numbers = []
    for i in range(5):
        numbers.append(i)
    assert numbers == [0, 1, 2, 3, 4]

    # The given end point is never part of the generated sequence; range(10)
    # generates 10 values, the legal indices for items of a sequence of length
    # 10. It is possible to let the range start at another number, or to specify
    # a different increment (even negative; sometimes this is called the
    # ‘step’):
    assert list(range(5, 10)) == [5, 6, 7, 8, 9]
    assert list(range(0, 10, 3)) == [0, 3, 6, 9]
    assert list(range(-10, -100, -30)) == [-10, -40, -70]

    # To iterate over the indices of a sequence, you can combine range() and
    # len() as follows:
    a = ['Mary', 'had', 'a', 'little', 'lamb']
    for i in range(len(a)):
        print(i, a[i])

    # In most such cases, however, it is convenient to use the enumerate() function
    a = ['Mary', 'had', 'a', 'little', 'lamb']
    for i, v in enumerate(a):
        assert v == a[i]
        print(i, v)

    # break and continue Statements, and else Clauses on Loops:
    # The break statement breaks out of the innermost enclosing for or while
    # loop. A for or while loop can include an else clause. In a for loop, the
    # else clause is executed after the loop reaches its final iteration. In a
    # while loop, it’s executed after the loop’s condition becomes false. In
    # either kind of loop, the else clause is not executed if the loop was
    # terminated by a break.
    for n in range(2, 10):
        for x in range(2, n):
            if n % x == 0:
                print(n, 'equals', x, '*', n//x)
                break
        else:
            # loop fell through without finding a factor
            print(n, 'is a prime number')

    # The continue statement, continues with the next iteration of the loop:
    for num in range(2, 10):
        if num % 2 == 0:
            print("Found an even number", num)
            continue
        print("Found an odd number", num)

    # The pass statement does nothing. It can be used when a statement is
    # required syntactically but the program requires no action. For example:
    x = 1  # so we don't loop forever below
    while x < 0:
        pass

    # Another place pass can be used is as a place-holder for a function or
    # conditional body when you are working on new code, allowing you to keep
    # thinking at a more abstract level. The pass is silently ignored:
    def initlog(*args):
        pass   # Remember to implement this!

    # match Statements: new in Python 3.10
    # A match statement takes an expression and compares its value to successive
    # patterns given as one or more case blocks. Only the first pattern that
    # matches gets executed and it can also extract components (sequence
    # elements or object attributes) from the value into variables. The simplest
    # form compares a subject value against one or more literals: Note the last
    # block: the "variable name" _ acts as a wildcard and never fails to match.
    # If no case matches, none of the branches is executed. You can combine
    # several literals in a single pattern using | (“or”):
    status = 418
    s = ""
    match status:
        case 400:
            s = "Bad request"
        case 404:
            s = "Not found"
        case 418:
            s = "I'm a teapot"
        case 401 | 403 | 404:
            s = "Not allowed"
        case _:
            s = "Something's wrong with the internet"
    assert s == "I'm a teapot"

    # Patterns can look like unpacking assignments, and can be used to bind variables:
    # point is an (x, y) tuple
    point = (0, 9)
    s = ""
    match point:
        case (0, 0):
            s = "Origin"
        case (0, y):
            s = f"Y={y}"
        case (x, 0):
            s = f"X={x}"
        case (x, y):
            s = f"X={x}, Y={y}"
        case _:
            s = "Not a point"
    # variable y is available after the match statement above
    assert s == f"Y={y}"

    # We can add an if clause to a pattern, known as a “guard”. If the guard is
    # false, match goes on to try the next case block. Note that value capture
    # happens before the guard is evaluated:
    point = (3, 3)
    s = ""
    match point:
        case (x, y) if x > y:
            s = f"Not on the diagonal x={x} > y={y}"
        case (x, y) if x < y:
            s = f"Not on the diagonal x={x} < y={y}"
        case (x, _):  # x should be equal to y
            s = f"Y=X at {x}"
    assert s == f"Y=X at {x}"


def defining_functions():

    # def f(pos1, pos2, /, pos_or_kwd, *, kwd1, kwd2):
    #       -----------    ----------     ----------
    #         |             |                  |
    #         |        Positional or keyword   |
    #         |                                - Keyword only
    #          -- Positional only
    #
    # where / and * are optional. If used, these symbols indicate the kind of
    # parameter by how the arguments may be passed to the function:
    # positional-only, positional-or-keyword, and keyword-only. Keyword
    # parameters are also referred to as named parameters.
    #
    # If / and * are not present in the function definition, arguments may be
    # passed to a function by position or by keyword.
    #
    # To mark parameters as keyword-only, indicating the parameters must be
    # passed by keyword argument, place an * in the arguments list just before
    # the first keyword-only parameter.

    # def foo(positional_only_parameters, /, positional_or_keyword_parameters,
    #          *, keyword_only_parameters):

    # All parameters left of the / are treated as positional-only. If / is not
    # specified in the function definition, that function does not accept any
    # positional-only arguments. The logic around optional values for
    # positional-only parameters remains the same as for positional-or-keyword
    # parameters. Once a positional-only parameter is specified with a default,
    # the following positional-only and positional-or-keyword parameters need to
    # have defaults as well. Positional-only parameters which do not have
    # default values are required positional-only parameters.

    # Therefore, the following would be valid function definitions:
    #   def foo(p1, p2, /, p_or_kw, *, kw):
    #   def foo(p1, p2=None, /, p_or_kw=None, *, kw):
    #   def foo(p1, p2=None, /, *, kw):
    #   def foo(p1, p2=None, /):
    #   def foo(p1, p2, /, p_or_kw):
    #   def foo(p1, p2, /):
    #   def foo(p_or_kw, *, kw):
    #   def foo(*, kw):

    # While the following would be invalid:
    #   def name(p1=None, p2, /, p_or_kw=None, *, kw):
    #   def name(p1, p2=None, /, p_or_kw, *, kw):
    #   def name(p1=None, p2, /):

    def standard_arg(arg):
        return arg

    def pos_only_arg(arg, /):
        return arg

    def kwd_only_arg(*, arg):
        return arg

    def combined_example(pos_only, /, standard, *, kwd_only):
        return pos_only, standard, kwd_only

    # variadic arguments
    def variadic_arg1(arg1, arg2, arg3=3, *args):
        return "".join([str(i) for i in [arg1, arg2, arg3] + list(args)])

    # variadic arguments
    def variadic_arg2(arg1, arg2, arg3=3, *args, **kwargs):
        r = f"arg1={arg1}, arg2={arg2}, arg3={arg3}"
        r += ", a:" + ", a:".join([str(i) for i in list(args)])
        r += ", kw:" + ", kw:".join([str(i) for i in list(kwargs.values())])
        return r

    assert standard_arg(2) == 2
    assert standard_arg(arg=2) == 2
    assert pos_only_arg(1) == 1
    assert kwd_only_arg(arg=3) == 3
    assert kwd_only_arg(arg=3) == 3
    assert combined_example(1, 2, kwd_only=3) == (1, 2, 3)
    assert combined_example(1, standard=2, kwd_only=3) == (1, 2, 3)

    assert variadic_arg1(1, 2, 4, 5, 6, 7, 8) == "1245678"

    s = variadic_arg2(1, 2, 4, 5, 6, 7, 8,
                      **{"k1": 1, "k2": 2})
    assert s == "arg1=1, arg2=2, arg3=4, a:5, a:6, a:7, a:8, kw:1, kw:2"

    # using / (positional only arguments) to avoid collision with kwds as it may
    # contain a key named 'bar'
    def foo(bar, /, **kwds):  # bar is positional only so we can have a key 'bar' in kwds
        print(f"bar={bar}")
        return 'bar' in kwds

    assert foo(1, **{'bar': 2, 'baz': 3})

    # same call will fail with the following error, if we do not use / :
    # TypeError: foo() got multiple values for argument 'name'
    def foo(bar,  **kwds):  # bar is positional only so we can have a key 'bar' in kwds
        print(f"bar={bar}")
        return 'bar' in kwds

    try:
        foo(1, **{'bar': 2, 'baz': 3})
        assert False  # should not fall down here
    except TypeError:
        pass

    # Important warning: The default value is evaluated only once. This makes a
    # difference when the default is a mutable object such as a list,
    # dictionary, or instances of most classes. For example, the following
    # function accumulates the arguments passed to it on subsequent calls:

    def foo(a, L=[]):
        L.append(a)
        return L

    assert foo(1) == [1]
    assert foo(2) == [1, 2]
    assert foo(3) == [1, 2, 3]

    my_list = []
    assert foo(8, L=my_list) == [8]
    assert foo(9, L=my_list) == [8, 9]

    # note that below uses the default empty list initialized in the very first
    # call to foo(1)
    assert foo(4) == [1, 2, 3, 4]

    # If you don’t want the default to be shared between subsequent calls, you
    # can write the function like this instead:
    def bar(a, L=None):
        if L is None:
            L = []
        L.append(a)
        return L

    assert bar(1) == [1]
    assert bar(2) == [2]
    assert bar(3) == [3]

    # Small anonymous functions can be created with the lambda keyword. This
    # function returns the sum of its two arguments: lambda a, b: a+b. Lambda
    # functions can be used wherever function objects are required. They are
    # syntactically restricted to a single expression. Semantically, they are
    # just syntactic sugar for a normal function definition. Like nested
    # function definitions, lambda functions can reference variables from the
    # containing scope:
    def make_incrementor(n):
        return lambda x: x + n

    f = make_incrementor(42)
    assert f(0) == 42
    assert f(1) == 43

    # Another use is to pass a small function as an argument:
    pairs = [(1, 'one'), (2, 'two'), (3, 'three'), (4, 'four')]
    pairs.sort(key=lambda pair: pair[1])
    assert pairs == [(4, 'four'), (1, 'one'), (3, 'three'), (2, 'two')]

    # Function annotations are completely optional metadata information about
    # the types used by user-defined functions (see PEP 3107 and PEP 484 for
    # more information).

    # Annotations are stored in the __annotations__ attribute of the function as
    # a dictionary and have no effect on any other part of the function.
    # Parameter annotations are defined by a colon after the parameter name,
    # followed by an expression evaluating to the value of the annotation.
    # Return annotations are defined by a literal ->, followed by an expression,
    # between the parameter list and the colon denoting the end of the def
    # statement. The following example has a required argument, an optional
    # argument, and the return value annotated:
    def foo(ham: str, eggs: str = 'eggs') -> str:
        print("Annotations:", foo.__annotations__)
        print("Arguments:", ham, eggs)
        return ham + ' and ' + eggs

    assert foo('chicken') == "chicken and eggs"

################################################################################


# arithmetic_operations()
# text_handling()
list_operations()
# control_flow()
# defining_functions()
