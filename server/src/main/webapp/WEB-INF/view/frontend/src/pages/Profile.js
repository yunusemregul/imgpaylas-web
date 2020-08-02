import React from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";

export default function Profile() {
  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Profilin" />
      <DivBackground backgroundColor="#444444"></DivBackground>
    </div>
  );
}
