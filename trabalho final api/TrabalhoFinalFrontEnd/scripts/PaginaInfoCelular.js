const produto = JSON.parse(localStorage.getItem("Produto"));

const divImg = document.querySelector("#img");
            const divInfo = document.querySelector("#info");
            
            const img = document.createElement("img");
            img.src = produto.img;
            const h1 = document.createElement("h1");
            h1.textContent = produto.nome;
            const h2 = document.createElement("h2");
            h2.textContent = "R$"+produto.valor;


            divImg.appendChild(img);
            divInfo.appendChild(h1);
            divInfo.appendChild(h2);
            const lista = document.createElement("ul");

            const info1 = document.createElement("li");
            info1.textContent = produto.processador;
            const info2 = document.createElement("li");
            info2.textContent = produto.chipset;
            const info3 = document.createElement("li");
            info3.textContent = produto.armazenamento;
            const info4 = document.createElement("li");
            info4.textContent = produto.ram;
            const info5 = document.createElement("li");
            info5.textContent = produto.tamTela;
            const info6 = document.createElement("li");
            info6.textContent = produto.camera;
            lista.appendChild(info1);
            lista.appendChild(info2);
            lista.appendChild(info3);
            lista.appendChild(info4);
            lista.appendChild(info5);
            lista.appendChild(info6);
            divInfo.appendChild(lista);