polyLength <- function(poly) {
  
  compu <- poly %>%
    mutate(dx = lag(x)) %>%
    mutate(dy=lag(y)) %>%  
    select(x, y, dx, dy)
  
  compu <- compu %>%
    filter(!is.na(dx))
  
  compu <- compu %>%
    mutate(diffX = (x-dx)^2, diffY = (y-dy)^2) %>%
    mutate(dist = sqrt(diffX + diffY))
  
  return(sum(compu$dist))
}

circle <- function(t) {
  point <- tibble(cos(2*pi*t), sin(2*pi*t))
  colnames(point) <- c("x", "y")
  return(point)
}