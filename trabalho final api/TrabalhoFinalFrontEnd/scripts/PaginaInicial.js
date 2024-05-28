document.addEventListener('DOMContentLoaded', ()=> {
    const a = document.querySelector("#produto");

    a.addEventListener("click", async function(event) {
        event.preventDefault(); //impede de navegar para o link do a e soluciona o problema de carregar a pag antes de fazer o get
       carregarPgProdutos(); 
    });
    const b = document.querySelector("#carrossel");

    b.addEventListener("click", async function(event) {
        event.preventDefault(); 
       carregarPgProdutos(); 
    });
    

const apiGetMet = 'http://localhost:8080/produtos/listarPagina?page=0&size=3';  
async function carregarPgProdutos() {
    try {
        const response = await fetch(apiGetMet);
        if (!response.ok) {
            throw new Error(response.status);
        }
        const data = await response.json();
        localStorage.setItem("produtos", JSON.stringify(data));
        window.location.href = "../paginas/Produto.html";
        
    } catch (error) {
        
    }
}
_});
