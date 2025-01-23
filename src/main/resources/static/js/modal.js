document.addEventListener('DOMContentLoaded', () => {
    const closeModalBtn = document.getElementById('closeModal');
    const modal = document.getElementById('myModal');

    // 모달 닫기 버튼 클릭 시 모달 닫기
    closeModalBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    // 모달 배경 클릭 시 모달 닫기
    window.addEventListener('click', (event) => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
});

function openModal(type, Id) {
    var url = "/study/details?studyId=";
    if(type === "board") url = "/board/detail?id=";

    // AJAX 요청
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url + Id, true); // 서버에서 HTML 내용 가져오기
    xhr.onload = function () {
        if (xhr.status === 200) {
            // 서버에서 받은 HTML을 모달에 삽입
            document.getElementById('modalBody').innerHTML = xhr.responseText;
            document.getElementById('myModal').style.display = 'block'; // 모달을 표시
        }
    };
    xhr.send();
}