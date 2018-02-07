$.ajax({
    url:"/initProgress",
    type:"post",
    success:data =>{
        if(data.type){ // 有未完后的进度
            let str = `
                     <h4>sorry!你有未完成的打卡进度！</h4>
                     <div>
                        时间：${data.unfinishedData.sdata}备注：${data.unfinishedData.bz}
                         <button id="progress-bqtime">补全时间</button>
                     </div>
                `;
            let strbq = ` <input type="text" value="2018-05-01 12:00" id="progress-text"><button id="progress-sctime">上传结束时间</button>`;

            $("#propress-err").html(str);

            $("#progress-bqtime").click(function () {
                $("#propress-input").html(strbq);
                $("#progress-sctime").click(function () {
                    $.ajax({
                        type:"post",
                        url:"addItemData",
                        data:{
                          edata:$("#progress-text").val()
                        },
                        success:function (data) {
                            if(data){
                                window.location.href = "/index"
                            }
                            console.log(data)
                        }
                    })
                });
            })
        }else{
            location.href = "/index"
        }
    }
})