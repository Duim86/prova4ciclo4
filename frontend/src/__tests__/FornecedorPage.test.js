import {render, screen} from '@testing-library/react'
import '@testing-library/jest-dom'
import FornecedorPage from '../pages/FornecedorPage'
import { act } from 'react-dom/test-utils'
import api from '../services/api'

describe('FornecedorPage', () => {
  test('deve buscar os Fornecedores ao carregar a página', async () => {
    const data = [{
      id: 1,
      nome: "Disk Duim",
    }, 
    {
      id: 2,
      nome: "Loja do Duim",
    }];
    const axiosGetSpy = jest.spyOn(api, 'get').mockResolvedValueOnce({ data });
    await act(async () => {
      render(<FornecedorPage />);
    });
    expect(axiosGetSpy).toBeCalledWith('/fornecedores');
    expect(screen.getByText(/disk duim/i)).toBeInTheDocument();
    axiosGetSpy.mockRestore();
  })

  test("Expected to find a button with text 'Novo Fornecedor' and href to '/fornecedor/novo'", () => {
    render(<FornecedorPage />);
    expect(screen.getByText(/novo fornecedor/i).closest('a')).toHaveAttribute('href', '/fornecedor/novo')
  });

})

