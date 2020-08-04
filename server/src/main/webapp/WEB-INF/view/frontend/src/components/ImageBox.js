import axios from "axios";
import React, { useState } from "react";
import icon_likes from "../assets/images/icon_likes.png";
import icon_likes_focused from "../assets/images/icon_likes_focused.png";
import icon_profile from "../assets/images/icon_profile.png";

export default function ImageBox(props) {
  const [imageLoaded, setImageLoaded] = useState(false);
  const [userLiked, setUserLiked] = useState(props.userLiked); // bad practice?
  const [data, setData] = useState(props.data); // bad practice?

  function refreshData() {
    axios.get("/api/v1/image/" + data.id).then((res) => {
      if (res.status === 200) {
        setData(res.data);
      }
    });
  }

  return (
    <div className="imagebox">
      <div
        className="imagebox-imgbox"
        style={
          !imageLoaded ? { backgroundColor: "rgba(" + data.col + ", 1)" } : {}
        } // fotoğraf yüklenene kadar temsilen fotoğrafın ortalama rengini gösteriyoruz
      >
        <img
          className="imagebox-img"
          src={data.url}
          loading="lazy"
          alt={data.desc}
          height={
            // fotoğraf daha yüklenmediğinde fotoğrafın yüksekliğini temsilen gösteriyoruz
            // fotoğraf yüklendiğinde layoutta hareketlilik olmasın diye
            // TODO: çok düzgün çalışmıyor
            !imageLoaded &&
            data.h /
              (data.w /
                (window.innerWidth /
                  (window.innerWidth < 400 ? 1 : window.innerWidth / 400)))
          }
          style={{ width: "100%" }}
          onLoad={() => {
            setImageLoaded(true);
          }}
        />
      </div>
      <div className="imagebox-desc">
        <div style={{ flex: "1 1 auto" }}>
          {data.desc}
          <br />
          <img
            src={icon_profile}
            width="20px"
            style={{ transform: "translateY(5px)", marginRight: "5px" }}
            alt=""
          />
          {data.uname}
        </div>
        <div
          onClick={() => {
            const method = userLiked ? axios.delete : axios.post;
            method("/api/v1/like/image/" + data.id).then((res) => {
              if (res.status === 200) {
                setUserLiked(!userLiked);
                refreshData();
              }
            });
          }}
          style={userLiked ? { color: "#FFC72E" } : {}}
        >
          {data.likes}{" "}
          <img
            style={{ width: "20px", transform: "translateY(5px)" }}
            src={userLiked ? icon_likes_focused : icon_likes}
            alt=""
          />
        </div>
      </div>
    </div>
  );
}
