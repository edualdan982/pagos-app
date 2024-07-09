## Generar claves RSA para la firma de token:

#### 1. Paso: Generar la clave privada
```bash
  openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -out app.key
```

#### 2. Paso: Generar la clave public a partir de la clave privada
```bash
  openssl rsa -pubout -in app.key -out app.pub
```