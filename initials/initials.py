def get_initials(fullname):
    """ Given a person's name, returns the person's initials (uppercase) """
    
    init = ''
    initials = fullname.split()
    for name in initials:
        init = init + name[0]
    
    return init.upper()

def main():
    
    fullname = input("What is your full name?")
    print(get_initials(fullname))

if __name__ == "__main__":
    main()