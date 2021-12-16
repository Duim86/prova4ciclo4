import { useState, useEffect } from 'react'
import { useParams, useNavigate } from "react-router";
import Header from "../components/Header"
import api from '../services/api';

function DetalhesTipoProduto() {
  const params = useParams();

  const [quantidade, setQuantidade] = useState(0)
  
  const [produto, setProduto] = useState({
    nome: "",
    produtoLista: []
  })

  useEffect(() => {
    api.get(`/produtos/${params.id}`).then(res => {
      setProduto(res.data)
    });
  }, [params.id]) 

  const navigate = useNavigate();

  function adicionarEstoque() {
    api.put(`/produtos/${params.id}/adicionarEstoque`, JSON.parse(Number(quantidade)), {
      headers: {
          'Content-Type': 'application/json',
      }
    }
    ).then(() => {
        alert('Produto adicionado com sucesso!');
        navigate('/')
        
    }).catch((e) => {
        alert(e.response.data.message);
    })
  }

  function removerEstoque() {
    api.put(`/produtos/${params.id}/removerEstoque`, JSON.parse(Number(quantidade)), {
      headers: {
          'Content-Type': 'application/json',
      }
    }
    ).then(() => {
        alert('Produto removido com sucesso!');
        navigate('/')
        
    }).catch((e) => {
        alert(e.response.data.message);
    })
  }

  return (
    <>
    <Header />
      <main>
        <div className="container mt-4">
            <div className="row">
                <div className="col-12">
                    <p><b>Nome:</b> <span>{produto.nome}</span></p>
                    <p><b>Preco Compra:</b> <span>R$ {produto.precoCompra}</span></p>
                    <p><b>Preco Venda:</b> <span>R$ {produto.precoVenda}</span></p>
                    <p><b>Tipo do Produto:</b> <span>{produto?.tipoProduto?.nome}</span></p>
                    <p><b>Fornecedor:</b> <span>{produto?.fornecedor?.nome}</span></p>
                    <p><b>Estoque:</b> <span>{produto.quantidade}</span></p>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <a className="btn btn-primary mt-5" href={`/produto/editar/${params.id}`}>Editar</a>
                </div>
            </div>
            <div className="row d-flex form-inline col-9">
              <div className="col-2">
                <button className="btn btn-primary mt-5" onClick={removerEstoque}>Remover</button>
              </div>  
              <input 
                className="col-1 mt-5 mr-3"
                name="quantidade" 
                label="Quantidade"
                value={quantidade}
                onChange={(e)=>{setQuantidade(e.target.value)}}
                type="number"
                required
            />
              <div className="col-2">
                <button type="button" className="btn btn-primary mt-5" 
                onClick={adicionarEstoque}>Adicionar</button>
              </div>              
            </div>            
        </div>
      </main>
    </>
  )
}

export default DetalhesTipoProduto
