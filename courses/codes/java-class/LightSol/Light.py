class Light:
    RED = "red"
    BLUE = "blue"
    GREEN = "green"
    WHITE = "white"

    def __init__(self, o=True, b=False, c=WHITE):
        self.burnt_out = b
        self.on = not b and o
        # self.color = c
        self.set_color(c)

    def __str__(self):
        return ("on " if self.on else "off ") + self.color + ("\t" if self.burnt_out else "\tnot ") + "burnt out"

    def burn_out(self):
        self.burnt_out = True
        self.on = False

    def flip(self):
        self.on = not self.on and not self.burnt_out

    def get_color(self):
        return self.color

    def set_color(self, c):
        self.color = c.lower()
        if self.color != Light.RED and self.color != Light.BLUE and self.color != Light.GREEN:
            self.color = Light.WHITE

    def is_on(self):
        return self.on

