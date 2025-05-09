def format_date(date):
    return date.strftime("%Y-%m-%d")

def calculate_percentage(part, whole):
    if whole == 0:
        return 0
    return (part / whole) * 100

def sanitize_input(input_string):
    return input_string.strip()