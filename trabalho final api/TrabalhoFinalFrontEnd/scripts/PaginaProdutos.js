const produtos = JSON.parse(localStorage.getItem("produtos"))


    

for (let i = 0; i < produtos.length; i++) {

    const idTitle = "#title"+(i+1)
    const title = document.querySelector(idTitle)
    const titleSave = document.createElement("h1")
    titleSave.textContent = produtos[i].nome
    title.appendChild(titleSave)
    for(let j = 0; j < 6; j++){


        const idImg = "#prod"+(i+1)+"Img" +(j+1);//prod2Img1
        const img = document.querySelector(idImg);
        const imgSave = document.createElement("img")
        const numImg = 'img' + (j+1)
        imgSave.src =produtos[i].img[numImg]
        img.appendChild(imgSave)
        
        
    }
    const idInfoCel = "#ifCel"+ (i+1);
    const infoCel= document.querySelector(idInfoCel);
    const info1 = document.createElement("li")
    info1.textContent = "Camera: "+produtos[i].camera
    const info2 = document.createElement("li")
    info2.textContent = "Chipset: "+produtos[i].chipset
    const info3 = document.createElement("li")
    info3.textContent ="Tela: "+ produtos[i].tamTela
    const info4 = document.createElement("li")
    info4.textContent ="Valor: R$" +produtos[i].precoUnitario
    infoCel.appendChild(info1)
    infoCel.appendChild(info2)
    infoCel.appendChild(info3)
    infoCel.appendChild(info4)


}

// transição para pagina Mais infos do celular

document.addEventListener('DOMContentLoaded', ()=>{
    const btnInfocel1 =  document.querySelector("#btnCel1")
    btnInfocel1.addEventListener("click", (event)=> {
        event.preventDefault();
        infoCelular("btnInfocel1")
    })
    
    const btnInfocel2 =  document.querySelector("#btnCel2")
    btnInfocel2.addEventListener("click", (event)=> {
        event.preventDefault();
        infoCelular("btnInfocel2")
    })
    const btnInfocel3 =  document.querySelector("#btnCel3")
    btnInfocel3.addEventListener("click", (event)=> {
        event.preventDefault();
        infoCelular("btnInfocel3")
    })
   
    function infoCelular(key) {
        for (let i = 0; i < produtos.length; i++) {
            const btnApertado = "btnInfocel"+(i+1)
          
            
            if (key == btnApertado) {
                const produto= {
                    nome : produtos[i].nome,
                    img: produtos[i].img.img1,
                    valor : produtos[i].precoUnitario,
                    processador : produtos[i].processador,
                    chipset : produtos[i].chipset,
                    armazenamento : produtos[i].armazenamento,
                    ram : produtos[i].ram,
                    tamTela : produtos[i].tamTela,
                    camera : produtos[i].camera,
                }
                localStorage.setItem("Produto",JSON.stringify(produto));
                window.location.href = "../paginas/infoProd.html";
            }
            
        }
    }

})
const carrinho1 = document.querySelector("#carrinho1");
carrinho1.addEventListener("click", ()=>{
    addCarrinho(carrinho1);
});
const carrinho2 = document.querySelector("#carrinho2");
carrinho2.addEventListener("click", ()=>{
    addCarrinho(carrinho2);
})
const carrinho3 = document.querySelector("#carrinho3");
carrinho3.addEventListener("click",()=>{
    addCarrinho(carrinho3);
}
)

function addCarrinho(key){
    
    if (key == carrinho1) {
        
        const produto ={
            nome : produtos[0].nome,
            img : produtos[0].img.img1,
            valor : produtos[0].precoUnitario,
            camera : produtos[0].camera,
            chipset: produtos[0].chipset,
            ram: produtos[0].ram,
        };
        const carrinhoString = localStorage.getItem("carrinho");
        const carrinho = JSON.parse(carrinhoString);
        carrinho.push(produto);
        alert("Produto adicionado ao carrinho");
        localStorage.setItem("carrinho",JSON.stringify(carrinho));
    }else if(key == carrinho2){
        const produto ={
            nome : produtos[1].nome,
            img : produtos[1].img.img1,
            valor : produtos[1].precoUnitario,
            camera : produtos[1].camera,
            chipset: produtos[1].chipset,
            ram: produtos[1].ram,
        };
        const carrinhoString = localStorage.getItem("carrinho");
        const carrinho = JSON.parse(carrinhoString);
        carrinho.push(produto);
        alert("Produto adicionado ao carrinho");
        localStorage.setItem("carrinho",JSON.stringify(carrinho));

    }else if(key == carrinho3){
        const produto ={
            nome : produtos[2].nome,
            img : produtos[2].img.img1,
            valor : produtos[2].precoUnitario,
            camera : produtos[2].camera,
            chipset: produtos[2].chipset,
            ram: produtos[2].ram,
        };
        const carrinhoString = localStorage.getItem("carrinho");
        const carrinho = JSON.parse(carrinhoString);
        carrinho.push(produto);
        alert("Produto adicionado ao carrinho");
        localStorage.setItem("carrinho",JSON.stringify(carrinho));
    }
}

document.addEventListener('DOMContentLoaded', ()=>{
    const pg1 = document.querySelector("#pg1");
    pg1.addEventListener("click", async function(event){
        event.preventDefault();
        trocarPag(pg1);
    });
    const pg2 = document.querySelector("#pg2")
    pg2.addEventListener("click", async function(event){
        event.preventDefault();
        trocarPag(pg2);
    })

    const apiGetPg1 = 'http://localhost:8080/produtos/listarPagina?page=0&size=3';
    const apiGetPg2 = 'http://localhost:8080/produtos/listarPagina?page=1&size=3';

    async function trocarPag(pg){

        if (pg == pg1) {
            
            const response = await fetch(apiGetPg1);
            if(!response.ok){
                throw new Error(response.status);
            }
            const data = await response.json();
            localStorage.setItem("produtos",JSON.stringify(data));
            window.location.href = "../paginas/Produto.html";
        } else if(pg == pg2){
            const response = await fetch(apiGetPg2);
            if(!response.ok){
                throw new Error(response.status);
            }
            const data = await response.json();
            localStorage.setItem("produtos",JSON.stringify(data));
            window.location.href = "../paginas/Produto.html";
        }
       
        

    }
})