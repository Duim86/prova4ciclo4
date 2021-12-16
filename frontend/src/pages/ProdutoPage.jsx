import {useState, useEffect } from "react"
import Header from "../components/Header"
import Table from "../components/Table"
import api from "../services/api"


function ProdutoPage() {
  const [produtos, setProdutos] = useState([])

  useEffect(() => {
    api.get('/produtos')
        .then(res => setProdutos(res.data));
  }, [])

  const removerProduto = (produtoId) => {
    api.delete(`/produtos/${produtoId}`).then(() => {
      alert('Registro removido com sucesso!');
      window.location.reload()
      
    }).catch(() => {
        alert('Erro ao remover!');
    })
  }

  return (
    <>
      <Header />
      <Table 
        name = 'produto'
        listEntity = {produtos}        
        remover = {removerProduto}
        buttonText = "Novo Produto"
      />
    </>    
  )
}

export default ProdutoPage