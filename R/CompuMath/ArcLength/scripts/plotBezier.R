library(bezier)
library(tidyverse)

# Parameterwerte erstellen
t <- seq(0, 1, length=100)
# Kontrollpolygon
p <- matrix(c(4, 1,  28, 48,  50, 42,  40, 5), nrow=4, ncol=2, byrow=TRUE)
# p als tibble
pTibble <- pTibble <- tibble(p[,1], p[,2])
colnames(pTibble) <- c("x", "y")

# Punkte auf Bezierkurve erzeugen zur grafischen Ausgabe
points <- bezier(t=t, p=p[1:4, 1:2])
pointsTibble <- tibble(points[,1], points[,2])
colnames(pointsTibble) <- c("x", "y")

# Grafische Ausgabe mit ggplot
plot1 <- ggplot() + 
  geom_path(data = pointsTibble, mapping=aes(x=x, y=y), size=2, color="orange") +
  geom_path(data = pTibble, mapping=aes(x=x, y=y), color="black")

# Grafik abspeichern
ggsave(filename="plot1.png", plot=plot1, device="png", 
      path="images/", width=16, height=9, units="cm")
  

# Wir hängen das zweite Segment an und erstellen eine grafische Darstellung
p2 <- matrix(c(40, 5,   30, -32,  25, -30,  10, -20), nrow=4, ncol=2, byrow=TRUE)
# p als tibble
p2Tibble <- tibble(p2[,1], p2[,2])
colnames(p2Tibble) <- c("x", "y")

# Punkte auf Bezierkurve erzeugen zur grafischen Ausgabe
points2 <- bezier(t=t, p=p2[1:4, 1:2])
points2Tibble <- tibble(points2[,1], points2[,2])
colnames(points2Tibble) <- c("x", "y")

# Grafische Ausgabe mit ggplot
plot2 <- ggplot() + 
  geom_path(data = pointsTibble, mapping=aes(x=x, y=y), size=2, color="orange") +
  geom_path(data = pTibble, mapping=aes(x=x, y=y), color="black") +
  geom_path(data = points2Tibble, mapping=aes(x=x, y=y), size=2, color="green") +
  geom_path(data = p2Tibble, mapping=aes(x=x, y=y), color="black")

# Grafik abspeichern
ggsave(filename="plot2.png", plot=plot2, device="png", 
       path="images/", width=16, height=9, units="cm")

# Grafische Ausgabe mit ggplot - nur die beiden Segmente, ohne
# Kontrollpolygon
plot3 <- ggplot() + 
  geom_path(data = pointsTibble, mapping=aes(x=x, y=y), size=2, color="orange") +
  geom_path(data = points2Tibble, mapping=aes(x=x, y=y), size=2, color="orange")

# Grafik abspeichern
ggsave(filename="plot3.png", plot=plot3, device="png", 
       path="images/", width=16, height=9, units="cm")