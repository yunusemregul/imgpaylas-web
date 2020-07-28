import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";
import { withRouter } from "react-router";
import Input from "../components/Input";
import queryString from "query-string";

const marginTop = { marginTop: "20px" };

function Login(props) {
  return (
    <div className="box">
      <Header />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center" method="post" action="/perform_login">
            <label className="form-label">Giriş Yap</label>
            <br />
            <Input
              type="text"
              placeholder="E-posta"
              id="email"
              autoFocus={true}
              style={marginTop}
            />
            <br />
            <Input
              type="password"
              placeholder="Şifre"
              id="password"
              style={marginTop}
            />
            <br />
            <button className="button" style={marginTop}>
              Giriş
            </button>
          </form>
        </div>
        <div className="absolute-centerx">
          Hesabın yok mu? <a href="/register">Kayıt Ol</a>
        </div>
      </DivBackground>
    </div>
  );
}

export default withRouter(Login);
