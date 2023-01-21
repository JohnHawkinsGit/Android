from fastapi import FastAPI

app = FastAPI()

@app.get("/")
async def raiz():
    return {"respuesta": "Hello World"}

@app.get("/suma/{n1}/{n2}/")
async def suma(n1:int, n2:int):
    s = n1 + n2
    return {"respuesta": s}

@app.get("/resta/{n1}/{n2}/")
async def resta(n1:int, n2:int):
    s = n1 - n2
    return {"respuesta": s}

@app.get("/mult/{n1}/{n2}/")
async def mult(n1:int, n2:int):
    s = n1 * n2
    return {"respuesta": s}

@app.get("/div/{n1}/{n2}/")
async def div(n1:int, n2:int):
    s = n1 / n2
    return {"respuesta": s}  