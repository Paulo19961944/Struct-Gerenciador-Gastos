package com.phsitedeveloper.gerenciadordegastos.action;

import com.phsitedeveloper.gerenciadordegastos.form.TransacaoForm;
import com.phsitedeveloper.gerenciadordegastos.model.GerenciadorFinanceiro;
import com.phsitedeveloper.gerenciadordegastos.model.Transacao;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenciadorAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        GerenciadorFinanceiro gerenciador = (GerenciadorFinanceiro) session.getAttribute("gerenciador");
        
        if (gerenciador == null) {
            gerenciador = new GerenciadorFinanceiro();
            session.setAttribute("gerenciador", gerenciador);
        }

        TransacaoForm transacaoForm = (TransacaoForm) form;
        String action = request.getParameter("action");

if ("adicionar".equals(action)) {
    // Adicionar nova transação usando Builder pattern
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date data = sdf.parse(transacaoForm.getData());

    Transacao transacao = new Transacao.Builder()
        .descricao(transacaoForm.getDescricao())
        .valor(Double.parseDouble(transacaoForm.getValor()))
        .tipo(transacaoForm.getTipo())
        .categoria(transacaoForm.getCategoria())
        .data(data)
        .build();

    gerenciador.adicionarTransacao(transacao);

} else if ("remover".equals(action)) {
            // Remover transação
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.parseLong(idParam);
                gerenciador.removerTransacao(id);
            }
        }

        // Atualizar estatísticas na sessão
        session.setAttribute("totalReceitas", gerenciador.getTotalReceitas());
        session.setAttribute("totalDespesas", gerenciador.getTotalDespesas());
        session.setAttribute("saldo", gerenciador.getSaldo());

        return mapping.findForward("success");
    }
}