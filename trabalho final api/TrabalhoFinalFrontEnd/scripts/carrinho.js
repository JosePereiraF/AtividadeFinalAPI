const carrinho = JSON.parse(localStorage.getItem("carrinho"));
const confirmacao = document.querySelector("#botao-confirmar-compra");

confirmacao.addEventListener("click", ()=>{
    Compra()//limpar o carrinho
})




function compra() {
    localStorage.setItem("carrinho", JSON.stringify([]))
}

const title = document.querySelector("#titulo-smartphone");
const h2 = document.createElement("h2");
const valorAvista = document.querySelector("#aVista");
const valorAprazo = document.querySelector("#aPrazo");
h2.textContent = "Carrinho";
title.appendChild(h2);
let total = 0;
carrinho.forEach((item)=>{
    const divDescricao = document.querySelector(".descricao-smartphone");//ok
    divDescricao.id ="divDescricao";
    const divImg = document.querySelector("#imagem-smartphone");//ok
    const img = document.createElement("img");
    
    img.src = item.img;
    img.id ="imgCelCarrinho";
    const valorNumber =  Number(item.valor);
    total += valorNumber;

    
    const divTotal = document.createElement("div");
    divTotal.id= "divTotal";
    const lista = document.createElement("ul");
    lista.id = "listaCarrinho";
    const info1 = document.createElement("li");
    info1.textContent = item.camera;
    const info2 = document.createElement("li");
    info2.textContent = item.chipset;
    const info3 = document.createElement("li");
    info3.textContent = item.ram;
    lista.appendChild(info1);
    lista.appendChild(info2);
    lista.appendChild(info3);
    divTotal.appendChild(lista);
    divTotal.appendChild(img);
    divDescricao.appendChild(divTotal);

})
const parcelado = document.createElement("p");
parcelado.textContent = "Apenas R$"+(total*1.2)+" em 12x. E você só começa a pagar em 60dias"
const avista = document.createElement("p");
avista.textContent = "À vista: de R$"+ total+",00 por apenas R$"+(total*0.9)+",00";
valorAprazo.appendChild(parcelado);
valorAvista.appendChild(avista);

console.log(total);

