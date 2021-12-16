import { useState, useEffect } from 'react'
import { useParams } from "react-router";
import { useNavigate } from 'react-router-dom';

import api from "../services/api"

function FormProduto() {
  const params = useParams();
  const produtoId = params.id === undefined ? null : params.id;

  const [produto, setProduto] = useState({
    id: produtoId,
    nome: "",
    precoCompra: null, 
    precoVenda: null,
    fornecedor: {
      id: params.idfornecedor
    },
    tipoProduto: {
      id: null
    }
  })

  const [fornecedores, setFornecedores] = useState([])
  const [tiposProduto, setTiposProduto] = useState([])


  const navigate = useNavigate();

  useEffect(() => {
    if(produtoId) {
      api.get(`/produtos/${produtoId}`).then(res => {
        setProduto(res.data)
      });
  }}, [produtoId])

  useEffect(() => {
    api.get(`/fornecedores`).then(res => {
      setFornecedores(res.data)
    });
  }, [])

  useEffect(() => {
    api.get(`/tiposProduto`).then(res => {
      setTiposProduto(res.data)
    });
  },[])

  useEffect(() => {
    console.log(produto)
  },[produto])

  function onSubmit(e) {
    e.preventDefault();
    if(produto.id !== null) {
      api.put(`/produtos/${produtoId}`, produto).then(() => {
          alert('Cadastro atualizado com sucesso!');
          navigate('/');
          
      }).catch((e) => {
          alert(e.response.data.message);
      })
    } else {
      api.post('/produtos', produto).then(() => {
          alert('Cadastro realizado com sucesso!');
          navigate('/');
          
      }).catch((error) => {
        alert(error.response.data.message);
      })
    }
  }

  return (
    <div className="container">
      <div className="row">
        <form onSubmit={onSubmit}>
          <div className="mt-3 mb-3">
            <label className="form-label">Nome do Produto</label>
            <input 
              className="form-control" 
              name="nome" 
              label="Nome completo" 
              value={produto.nome} 
              onChange={(e)=>{setProduto({...produto, nome: e.target.value})}}
              type="text"
              required
            />
            <label className="form-label">Preço Compra</label>
            <input 
              className="form-control" 
              name="precoCompra" 
              label="Preço Compra" 
              value={produto.precoCompra} 
              onChange={(e)=>{setProduto({...produto, precoCompra: e.target.value})}}
              type="number"
              required
            />
            <label className="form-label">Preço Venda</label>
            <input 
              className="form-control" 
              name="precoVenda" 
              label="Preço Venda" 
              value={produto.precoVenda} 
              onChange={(e)=>{setProduto({...produto, precoVenda: e.target.value})}}
              type="number"
              required
            />
            <label className="form-label">Tipo Produto</label>
            <select 
              className="form-select" 
              onChange={(e)=>{setProduto({...produto, tipoProduto: {
                id: Number(e.target.value)
              }})}}>
              
              <option value="" hidden selected disabled>Selecione uma opção</option>
              {tiposProduto.map(tipoProduto => {
                return <option key={tipoProduto.id} value={tipoProduto.id} selected={tipoProduto.id === produto?.tipoProduto?.id}>{tipoProduto.nome}</option>
              })}  
            </select>    
            {!params.idfornecedor && 
              <div>
                <label className="form-label">Fornecedor</label>       
                <select
                  className="form-select" 
                  onChange={(e)=>{setProduto({...produto, fornecedor: {
                    id: Number(e.target.value)
                  }})}}>
                  <option value="" hidden selected disabled>Selecione uma opção</option>
                  {fornecedores.map(fornecedor => {
                    return <option key={fornecedor.id} value={fornecedor.id} selected={fornecedor.id === produto?.fornecedor?.id}>{fornecedor.nome}</option>
                  })}  
                </select>
              </div>
            }
          </div>
          <button id="btn-cadastrar" className="btn btn-primary" type="submit">Cadastrar</button>
        </form>
      </div>
    </div>
  )
}

export default FormProduto;