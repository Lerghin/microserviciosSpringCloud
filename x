version: "3.9"  # Updated to a supported version

services:
  eureka-sv:
    build: eureka-sv
    mem_limit: 512m
    ports:
      - "8761:8761"
    networks:
      - productoscartventas-network

  productos:
    build: Productos
    mem_limit: 512m
    ports:
      - "8082:8082"
    networks:
      - productoscartventas-network

  carrito:
    build: Carrito
    mem_limit: 512m
    ports:
      - "9097:9097"
    networks:
      - productoscartventas-network

  ventas:
    build: ventas
    mem_limit: 512m
    ports:
      - "9091:9091"
    networks:
      - productoscartventas-network

  api-gateway:
    build: api-gateway
    mem_limit: 512m
    ports:
      - "9098:9098"
    networks:
      - productoscartventas-network

networks:
  productoscartventas-network:

