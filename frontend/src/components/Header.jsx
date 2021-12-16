function Header() {
  return (
    <header>
      <div className="container mt-3">
          <ul className="nav nav-tabs">
              <li className="nav-item d-flex">
                  <a aria-current="page" className="nav-link" href="/">Home</a>
                  <a aria-current="page" className="nav-link" href="/fornecedor">Fornecedor</a>
                  <a aria-current="page" className="nav-link" href="/produto">Produto</a>
                  <a aria-current="page" className="nav-link" href="/tiposProduto">Tipo Produto</a>
              </li>
          </ul>
      </div>
    </header>
  )
}

export default Header
