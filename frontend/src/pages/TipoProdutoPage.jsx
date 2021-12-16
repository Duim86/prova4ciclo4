import {useState, useEffect } from "react"
import Header from "../components/Header"
import Table from "../components/Table"
import api from "../services/api"


function TipoProdutoPage() {
  const [tiposProduto, setTiposProduto] = useState([])

  useEffect(() => {
    api.get('/tiposProduto')
        .then(res => setTiposProduto(res.data));
  }, [])

  const removerTipoProduto = (tipoProdutoId) => {
    api.delete(`/tiposProduto/${tipoProdutoId}`).then(() => {
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
        name = 'tiposProduto'
        listEntity = {tiposProduto}        
        remover = {removerTipoProduto}
        buttonText = "Novo Tipo Produto"
      />
    </>      
  )
}

export default TipoProdutoPage