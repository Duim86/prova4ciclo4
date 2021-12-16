import {Routes, Route} from 'react-router-dom';

import Landing from './pages/Landing';

import FornecedorPage from './pages/FornecedorPage';
import TipoProdutoPage from './pages/TipoProdutoPage';
import ProdutoPage from './pages/ProdutoPage';

import FormProdutoPage from './pages/FormProdutoPage';
import FormTipoProdutoPage from './pages/FormTipoProdutoPage';
import FormFornecedorPage from './pages/FormFornecedorPage';

import DetalhesProduto from './pages/DetalhesProduto';
import DetalhesTipoProduto from './pages/DetalhesTipoProduto';
import DetalhesFornecedor from './pages/DetalhesFornecedor';

function MainRoutes() {
  return (
  <Routes>
      <Route path="/" element={<Landing />} />
      <Route path="/fornecedor" exact element={<FornecedorPage />} />
      <Route path="/fornecedor/novo" element={<FormFornecedorPage />} />
      <Route path="/fornecedor/:idfornecedor/novo/produto" element={<FormProdutoPage />} />
      <Route path={`/fornecedor/editar/:id`} element={<FormFornecedorPage />} />
      <Route path={`/fornecedor/detalhes/:id`} element={<DetalhesFornecedor />} />

      <Route path={`/tiposProduto`} element={<TipoProdutoPage />} />
      <Route path="/tiposProduto/novo" element={<FormTipoProdutoPage />} />
      <Route path={`/tiposProduto/editar/:id`} element={<FormTipoProdutoPage />} />
      <Route path={`/tiposProduto/detalhes/:id`} element={<DetalhesTipoProduto />} />

      <Route path={`/produto`} element={<ProdutoPage />} />
      <Route path="/produto/novo" element={<FormProdutoPage />} />
      <Route path={`/produto/editar/:id`} element={<FormProdutoPage />} />
      <Route path={`/produto/detalhes/:id`} element={<DetalhesProduto />} />


  </Routes>
  );
}

export default MainRoutes;