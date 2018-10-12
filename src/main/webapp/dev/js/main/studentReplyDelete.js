import {
    showModalConfirmation,
} from '../common/bootboxWrapper';

import {
    BootstrapContextualColors,
} from '../common/const';

function bindDeleteButtons() {
    $('body').on('click', '.topic_delete_', (event) => {
        event.preventDefault();

        const $button = $(event.currentTarget);

        const messageText = `Are you sure you want to delete this reply?`;

        const okCallback = function () {
            window.location = $button.attr('href');
        };

        showModalConfirmation('Confirm deleting reply', messageText, okCallback, null,
                null, null, BootstrapContextualColors.DANGER);
    });
}

$(document).ready(() => {
  bindDeleteButtons();
});
